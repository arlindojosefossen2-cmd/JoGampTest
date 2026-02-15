package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class GameInputListener implements KeyListener
{
	private final boolean[] keys = new boolean[256];

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		keys[keyEvent.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		keys[keyEvent.getKeyCode()] = false;
	}

	public boolean isKeyDown(int keyVCode)
	{
		return keys[keyVCode];
	}
}
