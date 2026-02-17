package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

import java.util.Arrays;

public final class GameInputListener implements KeyListener
{
	private final boolean[] keys;
	private final int[] polled;

	public GameInputListener()
	{
		keys = new boolean[256];
		polled = new int[256];
	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		int keyPressed = keyEvent.getKeyCode();

		if(keyPressed >= 0 && keyPressed < keys.length)
		{
			keys[keyPressed] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		int keyRelease = keyEvent.getKeyCode();

		if(keyRelease >= 0 && keyRelease < keys.length)
		{
			keys[keyRelease] = false;
		}
	}

	public void pollEvent()
	{
		for (int i = 0; i < keys.length; i++)
		{
			if(keys[i])
			{
				polled[i]++;
			}
			else
			{
				polled[i] = 0;
			}
		}
	}

	public boolean isKeyDown(int keyCode)
	{
		return polled[keyCode] > 0;
	}

	public boolean isKeyDownOnce(int keyCode)
	{
		return polled[keyCode] == 1;
	}

	public void reset()
	{
		Arrays.fill(polled,0);
		Arrays.fill(keys,false);
	}
}
