package br.com.jogamptest.main;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject implements IGameObject
{
	protected float x;
	protected   float y;

	protected int width;
	protected int height;

	protected float rotation;

	protected List<IAnimation> animations;
	protected int index;

	public GameObject(float x,float y)
	{
		this.x = x;
		this.y = y;
		this.rotation = 0;
		this.animations = new ArrayList<>();
		this.index = 0;
	}

	@Override
	public void draw(GL2Graphics graphics)
	{
		if(graphics != null)
		{
			if(this.index >= 0 && this.index <= this.animations.size())
			{
				this.animations.get(this.index).draw(graphics, this.x, this.y, this.rotation);
				graphics.drawRect(IntColorPalette.RED,x,y,width,height,rotation);
			}
		}
	}

	@Override
	public void dispose()
	{
		for (IAnimation animation : this.animations)
		{
			animation.dispose();
		}
	}
}
