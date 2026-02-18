package br.com.jogamptest.main;

import java.awt.event.KeyEvent;

public final class Player extends GameObject
{
	public static final float SPEED = 5f;

	private boolean moving;
	private int direction;

	private final Game game;

	public Player(Game game,float x, float y)
	{
		super(x, y);
		this.game = game;
		this.moving = false;
		this.direction = 0;
	}

	@Override
	public void start()
	{
		x = .5f;
		y = .5f;

		this.animations.add(new Animation(new String[]
				{
						"/girl_0.png",
						"/girl_1.png",
						"/girl_2.png",
				},10));
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

		this.animations.get(this.index).update(delta);
	}
}
