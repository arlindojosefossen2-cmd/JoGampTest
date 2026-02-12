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
	private Main()
	{

	}
	public static void main(String[] args)
	{
		System.out.println("Joga mp Test");

		GLProfile.initSingleton();

		GLProfile profile = GLProfile.get(GLProfile.GL2);

		GLCapabilities caps = new GLCapabilities(profile);

		GLWindow window = GLWindow.create(caps);
		window.setSize(720,596);
		window.setTitle("Joga mp-Game-Test");

	    GraphicsDevice dev = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		DisplayMode displayMode = dev.getDisplayMode();
		window.setPosition(displayMode.getWidth()/2-window.getWidth()/2,displayMode.getHeight()/2-window.getHeight()/2);

		FPSAnimator fps = new FPSAnimator(window,60);

		KeyListener input = new GameInputListener();
		window.addKeyListener(input);

		MouseListener mouse = new GameMouseListener();
		window.addMouseListener(mouse);

		WindowListener windowListener = new WindowResetListeners();
		window.addWindowListener(windowListener);

		GLEventListener glWindowListener = new GLWindowEventListener();
		window.addGLEventListener(glWindowListener);

		window.setResizable(false);
		window.setVisible(true);

		while(window.isVisible())
		{
			window.display();
			System.out.println("FPS: "+fps.getFPS());
		}

		//clear listeners
		window.removeKeyListener(input);
		window.removeMouseListener(mouse);
		window.removeWindowListener(windowListener);
		window.removeGLEventListener(glWindowListener);

		window.destroy();
	}
}
