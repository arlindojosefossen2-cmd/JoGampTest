package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import java.awt.*;

public final class Main
{
	private Main()
	{

	}
	public static void main(String[] args)
	{
		System.out.println("Jogamp Test");

		GLProfile.initSingleton();

		GLProfile profile = GLProfile.get(GLProfile.GL3);

		GLCapabilities caps = new GLCapabilities(profile);

		GLWindow window = GLWindow.create(caps);
		window.setSize(720,596);
		window.setTitle("Jogamp-Game-Test");

	    GraphicsDevice dev = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		DisplayMode displayMode = dev.getDisplayMode();
		window.setPosition(displayMode.getWidth()/2-window.getWidth()/2,displayMode.getHeight()/2-window.getHeight()/2);

		KeyListener input = new GameInputListener();
		window.addKeyListener(input);

		MouseListener mouse = new GameMouseListener();
		window.addMouseListener(mouse);

		WindowListener windowListener = new WindowResetListeners();
		window.addWindowListener(windowListener);

		window.setResizable(false);
		window.setVisible(true);

		while(window.isVisible())
		{

			window.display();
		}

		window.removeKeyListener(input);
		window.removeMouseListener(mouse);
		window.removeWindowListener(windowListener);

		window.destroy();
	}
}
