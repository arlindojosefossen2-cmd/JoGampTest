package br.com.jogamptest.main;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;

import javax.swing.*;
import java.awt.*;

public abstract class Game implements Runnable
{
	public static final int UNITS = 10;

	private static GLWindow window;
	private static GLProfile profile;

	private final String title;
	private final int width;
	private final int height;
	private int fpsSleep;

	public GameInputListener input;
	public GameMouseListener mouse;
	private WindowResetListeners windowListener;
	private GLWindowEventListener glEventListener;

	protected Scene currentScene;
	private Thread gameThread;
	private boolean running;
	private final FrameRate frameRate = new FrameRate();

	public final GameCamera2D camera = new GameCamera2D();

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

	private void init(int fpsSleep,boolean centerOfScreen)
	{
		this.fpsSleep = fpsSleep;
		//initialize the singleton for default profile to you System
		GLProfile.initSingleton();

		try
		{
			//create profile GL or GL2 or GL3 etc.
			profile = GLProfile.get(GLProfile.GL2);

			//create capabilities
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

			//add listeners to window
			input = new GameInputListener();
			window.addKeyListener(input);

			mouse = new GameMouseListener(this);
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
			gameThread.setName("Game");
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
		frameRate.initialize();

		long curTime = System.nanoTime();
		long lastTime = curTime;

		double nsPerFrame;

		while(running)
		{
			frameRate.calculate();

			input.pollEvent();
			mouse.pollEvent();

			if (input.isKeyDownOnce(com.jogamp.newt.event.KeyEvent.VK_ESCAPE))
			{
				break;
			}

			curTime = System.nanoTime();
			nsPerFrame = curTime - lastTime;

			currentScene.input((float) (nsPerFrame / 1.0E9));
			currentScene.update((float) (nsPerFrame / 1.0E9));

			update();

			sleep(fpsSleep);

			lastTime = curTime;
		}
	}

	private void sleep(int fpsSleep)
	{
		try
		{
			Thread.sleep(fpsSleep);
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static void launch(Game game,int fpsSleep,boolean centerOfScreen)
	{
		SwingUtilities.invokeLater(()->
				game.init(fpsSleep,centerOfScreen));
	}

	private void update()
	{
		//update window
		window.display();
		window.setTitle(String.format("%s-FPS: %s", this.title, this.frameRate.getFrameRate()));
	}
	void destroy()
	{
		//clear listeners
		window.removeKeyListener(input);
		window.removeMouseListener(mouse);
		window.removeWindowListener(windowListener);
		window.removeGLEventListener(glEventListener);

		//destroy window
		window.destroy();

		//stop the gameThread
		stop();
	}

	private void stop()
	{
		running = false;

		try
		{
			gameThread.join(5000L);
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static GLProfile getProfile()
	{
		return profile;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
