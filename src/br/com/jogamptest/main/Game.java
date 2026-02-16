package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;

public abstract class Game implements Runnable
{
	public static final int UNITS = 10;

	private GLWindow window;

	private final String title;
	private final int width;
	private final int height;
	private int fps;

	public GameInputListener input;
	public GameMouseListener mouse;
	private WindowResetListeners windowListener;
	private GLWindowEventListener glEventListener;

	private FPSAnimator windowFPSAnimator;

	protected Scene currentScene;
	private Thread gameThread;
	private boolean running;

	protected Game(String title,int width,int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
	}

	protected void addScene(Scene scene)
	{
		this.currentScene = scene;
	}

	private void init(int fps,boolean centerOfScreen)
	{
		this.fps = fps;
		//initialize the singleton for default profile to you System
		GLProfile.initSingleton();

		try
		{

			//create profile GL or GL2 or GL3 etc.
			GLProfile profile = GLProfile.get(GLProfile.GL2);

			GLCapabilities caps = new GLCapabilities(profile);

			//create window define title and size
			window = GLWindow.create(caps);

			window.setTitle(title);
			window.setSize(width, this.height);

			if (centerOfScreen)
			{
				//get device to set window on center of screen
				GraphicsDevice dev = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
				DisplayMode displayMode = dev.getDisplayMode();

				//set position to window
				window.setPosition(displayMode.getWidth() / 2 - window.getWidth() / 2, displayMode.getHeight() / 2 - window.getHeight() / 2);
			}

			windowFPSAnimator = new FPSAnimator(window,60);
			windowFPSAnimator.start();

			//add listeners to window
			input = new GameInputListener();
			window.addKeyListener(input);

			mouse = new GameMouseListener();
			window.addMouseListener(mouse);

			windowListener = new WindowResetListeners(this);
			window.addWindowListener(windowListener);

			GL2Graphics graphics = new GL2Graphics();
			glEventListener = new GLWindowEventListener(this, graphics);
			window.addGLEventListener(glEventListener);

			//set false to resizable
			window.setResizable(false);

			//set visible true for see the window
			window.setVisible(true);

			gameThread = new Thread(this);
			gameThread.start();

		}
		catch(GLException glException)
		{
			JOptionPane.showMessageDialog(null,"ERROR: "+glException.getMessage());
		}
	}

	@Override
	public synchronized void run()
	{
		running = true;

		while(running)
		{
			input.pollEvent();
			mouse.pollEvent();

			currentScene.input();
			currentScene.update();

			if(input.isKeyDownOnce(KeyEvent.VK_ESCAPE))
			{
				running = false;
				window.setVisible(false);
			}

			try
			{
				Thread.sleep(20L);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
	}

	public static void launch(Game game,int fps,boolean centerOfScreen)
	{
		SwingUtilities.invokeLater(()->
		{
			game.init(fps,centerOfScreen);
			game.update();
			game.destroy();
		});
	}

	private void update()
	{
		//update window

		while(window.isVisible())
		{
			window.display();
			window.setTitle(String.format("%s-FPS: %s", this.title, this.fps));
		}
	}
	private void destroy()
	{
		//clear listeners
		window.removeKeyListener(input);
		window.removeMouseListener(mouse);
		window.removeWindowListener(windowListener);
		window.removeGLEventListener(glEventListener);

		if(!window.isVisible())
		{
			windowFPSAnimator.stop();


		}

		//destroy window
		window.destroy();
	}

	public void stop()
	{
		running = false;
		//stop the thread
		try
		{
			gameThread.join();
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}
}
