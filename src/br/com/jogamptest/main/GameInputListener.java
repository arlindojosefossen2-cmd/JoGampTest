package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class GameInputListener implements KeyListener
{
	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		System.out.println("pressed: "+keyEvent.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		System.out.println("Release: "+keyEvent.getKeyCode());
	}
}
