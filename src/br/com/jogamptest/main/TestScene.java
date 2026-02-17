package br.com.jogamptest.main;

import java.awt.event.KeyEvent;


public final class TestScene implements Scene
{
	public static final float SPEED = 5f;

	public final Game game;

	private GLImage img;

	private float x;
	private float y;

	private boolean moving;
	private int direction;

	public TestScene(Game game)
	{
		this.game = game;
	}

	@Override
	public void start()
	{
		x = .5f;
		y = .5f;

		img = new GLImage("/girl.png");
	}

	@Override
	public void input(float delta)
	{
		if (game.input.isKeyDown(KeyEvent.VK_W))
		{
			moving = true;
			direction = 0;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_D))
		{
			moving = true;
			direction = 1;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_A))
		{
			moving = true;
			direction = 2;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_S))
		{
			moving = true;
			direction = 3;
		}
		else
		{
			moving = false;
		}
	}

	@Override
	public void update(float delta)
	{
		if(moving)
		{
			switch (direction)
			{
				case 0:
					y += SPEED*delta;
					break;
				case 1:
					x += SPEED*delta;
					break;
				case 2:
					x -= SPEED*delta;
					break;
				case 3:
					y -= SPEED*delta;
					break;
			}
		}
	}

	@Override
	public void draw(GL2Graphics graphics)
	{
		if(graphics != null)
		{
			if(img.getTexture() != null)
			{
				graphics.drawTexture(img.getTexture(),x,y,img.getWidth(),img.getHeight());
			}
		}

	}

	@Override
	public void stop()
	{
		img.dispose();
	}
}
