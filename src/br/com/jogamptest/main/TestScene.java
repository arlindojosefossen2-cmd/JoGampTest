package br.com.jogamptest.main;

import java.awt.event.KeyEvent;


public final class TestScene implements Scene
{
	public static final float SPEED = .1f;

	public final Game game;

	private GLImage img;

	private float x;
	private float y;

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
//			graphics.drawRect(GL2PaletteColor.RED,x, y, 1,1,0);

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
