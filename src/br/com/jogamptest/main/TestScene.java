package br.com.jogamptest.main;

import java.awt.event.KeyEvent;

public final class TestScene implements Scene
{
	public static final float SPEED = .1f;

	public final Game game;

	private float x;
	private float y;
	private float size;

	public TestScene(Game game)
	{
		this.game = game;
	}

	@Override
	public void start()
	{
		System.out.println("start");
		x = .5f;
		y = .5f;
		size = 1;
	}

	@Override
	public void input()
	{

		if (game.input.isKeyDown(KeyEvent.VK_W))
		{
			System.out.println("input W");
			y += SPEED;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_D))
		{
			System.out.println("input A");
			x += SPEED;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_A))
		{
			System.out.println("input W");
			x -= SPEED;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_S))
		{
			System.out.println("input A");
			y -= SPEED;
		}
	}

	@Override
	public void update()
	{
		System.out.println("update");


	}

	@Override
	public void draw(GL2Graphics graphics)
	{
		System.out.println("draw");

		if(graphics != null)
		{
			graphics.fillRect(GL2PaletteColor.RED,x, y, size, size);
		}
	}

	@Override
	public void stop()
	{
		System.out.println("stop");
	}
}
