package br.com.jogamptest.main;

import com.jogamp.newt.event.MouseEvent;

import java.awt.event.KeyEvent;

public final class Player extends GameObject
{
	public static final float SPEED = 1f;
	public static final int DIRECTION_UP = 3;
	public static final int DIRECTION_LEFT = 2;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_DOWN = 0;

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
		x = 0f;
		y = 0f;

		this.animations.add(new Animation(new String[]
				{
						"/girl_0.png",
						"/girl_1.png",
						"/girl_2.png",
				},10));

		width = 32/Game.UNITS/2;
		height = 32/Game.UNITS/2;
	}

	@Override
	public void input(float delta)
	{
		if (game.input.isKeyDown(KeyEvent.VK_W))
		{
			moving = true;
			direction = DIRECTION_DOWN;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_D))
		{
			moving = true;
			direction = DIRECTION_RIGHT;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_A))
		{
			moving = true;
			direction = DIRECTION_LEFT;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_S))
		{
			moving = true;
			direction = DIRECTION_UP;
		}
		else
		{
			moving = false;
		}

		if(game.mouse.isButtonDownOnce(MouseEvent.BUTTON1))
			System.out.println(game.mouse.getMousePosition());
	}

	@Override
	public void update(float delta)
	{
		if(moving)
		{
			switch (direction)
			{
				case DIRECTION_DOWN:
					y += SPEED*delta;
					break;
				case DIRECTION_RIGHT:
					x += SPEED*delta;
					break;
				case DIRECTION_LEFT:
					x -= SPEED*delta;
					break;
				case DIRECTION_UP:
					y -= SPEED*delta ;
					break;
			}
		}

		this.animations.get(this.index).update(delta);
	}
}
