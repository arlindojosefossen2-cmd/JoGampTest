package br.com.jogamptest.main;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

import java.util.Arrays;

public final class GameInputListener implements KeyListener
{
	private boolean[] keys;
	private int[] polled;
	private int keyPressed;
	private int keyRelease;

	public GameInputListener()
	{
		keys = new boolean[256];
		polled = new int[256];
	}

	@Override
	public synchronized void keyPressed(KeyEvent keyEvent)
	{
		keyPressed = keyEvent.getKeyCode();

		if(keyPressed >= 0 && keyPressed < keys.length)
		{
			keys[keyPressed] = true;
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent keyEvent)
	{
		keyRelease = keyEvent.getKeyCode();

		if(keyRelease >= 0 && keyRelease < keys.length)
		{
			keys[keyRelease] = false;
		}
	}

	public synchronized void pollEvent()
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

	public synchronized boolean isKeyDown(int keyVCode)
	{
		return (polled[keyVCode]  > 0);
	}

	public synchronized boolean isKeyDownOnce(int keyVCode)
	{
		return (polled[keyVCode]  == 1);
	}

	public void reset()
	{
		Arrays.fill(polled,0);
		Arrays.fill(keys,false);
	}
}
