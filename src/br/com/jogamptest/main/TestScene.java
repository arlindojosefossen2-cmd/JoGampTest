package br.com.jogamptest.main;

import java.awt.event.KeyEvent;


public final class TestScene implements Scene
{
	public static final float SPEED = .1f;

	public final Game game;

	private GLImage img;

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
		x = .5f;
		y = .5f;
		size = 1;

		img = new GLImage("/girl.png");
	}

	@Override
	public void input()
	{
		if (game.input.isKeyDown(KeyEvent.VK_W))
		{
			y += SPEED;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_D))
		{
			x += SPEED;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_A))
		{
			x -= SPEED;
		}
		else if (game.input.isKeyDown(KeyEvent.VK_S))
		{
			y -= SPEED;
		}
	}

	@Override
	public void update()
	{



	}

	@Override
	public void draw(GL2Graphics graphics)
	{
		if(graphics != null)
		{
//			graphics.fillRect(GL2PaletteColor.RED,x, y, size, size);

			if(img.getTexture() != null)
			{
				graphics.drawTexture(img.getTexture(),GL2PaletteColor.WHITE,x,y,size,size,0);
			}
		}

	}

	@Override
	public void stop()
	{
		img.dispose();
	}
}
