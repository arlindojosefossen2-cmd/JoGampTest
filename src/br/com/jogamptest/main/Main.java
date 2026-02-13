package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;

public final class Main
{
	public static final int UNITS = 100;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 576;

	private Main()
	{

	}
	public static void main(String[] args)
	{
		System.out.println("Joga mp Test");

		//initialize the singleton for default profile to you System
		GLProfile.initSingleton();

		//create profile GL or GL2 or GL3 etc.
		GLProfile profile = GLProfile.get(GLProfile.GL2);

		//create capabilities using profile
		GLCapabilities caps = new GLCapabilities(profile);

		//create window define title and size
		GLWindow window = GLWindow.create(caps);
		window.setSize(WIDTH,HEIGHT);
		window.setTitle("Joga mp-Game-Test");

		//get device to set window on center of screen
	    GraphicsDevice dev = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		DisplayMode displayMode = dev.getDisplayMode();

		//set position to window
		window.setPosition(displayMode.getWidth()/2-window.getWidth()/2,displayMode.getHeight()/2-window.getHeight()/2);

		//add window to FPSAnimator
		FPSAnimator fps = new FPSAnimator(window,60);

		//add listeners to window
		KeyListener input = new GameInputListener();
		window.addKeyListener(input);

		MouseListener mouse = new GameMouseListener();
		window.addMouseListener(mouse);

		WindowListener windowListener = new WindowResetListeners();
		window.addWindowListener(windowListener);

		GLEventListener glWindowListener = new GLWindowEventListener();
		window.addGLEventListener(glWindowListener);

		//set false to resizable
//		window.setResizable(false);

		//set visible true for see the window
		window.setVisible(true);
		final String title = window.getTitle();

		//update window
		while(window.isVisible())
		{
			window.display();
			window.setTitle(String.format("%s-FPS: %s",title,fps.getFPS()));
		}

		//clear listeners
		window.removeKeyListener(input);
		window.removeMouseListener(mouse);
		window.removeWindowListener(windowListener);
		window.removeGLEventListener(glWindowListener);

		//destroy window
		window.destroy();
	}
}
