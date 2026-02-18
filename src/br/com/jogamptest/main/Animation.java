package br.com.jogamptest.main;

public final class Animation implements IAnimation
{
	private int index;
	private float counter;

	private final int interval;
	private final boolean looping;
	private final GLImage[] images;

	public Animation(String[] filePaths,int interval)
	{
		this(filePaths,interval,true);
	}

	public Animation(String[] filePaths,int interval,boolean looping)
	{
		this.images = new GLImage[filePaths.length];
		this.interval = interval;
		this.looping = looping;

		int i = 0;
		for (String aux : filePaths)
		{
			this.images[i++] = new GLImage(aux);
		}

		this.index = 0;
		this.counter = 0;
	}

	@Override
	public void update(float delta)
	{
		if(!this.looping && this.index == this.images.length - 1)
		{
			return;
		}

		this.counter++;

		if(this.counter >= this.interval)
		{
			this.index++;
			this.counter = 0;

			if(this.index >= this.images.length)
			{
				this.index = 0;
			}
		}
	}

	@Override
	public void draw(GL2Graphics graphics,float xPos,float yPos,float rotation)
	{
		if(graphics != null && this.index >= 0 && this.index <= this.images.length)
		{
			graphics.drawTexture(
					this.images[this.index].getTexture(),
					xPos, yPos,
					this.images[this.index].getWidth(),
					this.images[this.index].getHeight(),
					rotation);
		}
	}

	@Override
	public boolean isFinished()
	{
		return (this.index == this.images.length - 1);
	}

	@Override
	public boolean isLooping()
	{
		return this.looping;
	}

	@Override
	public boolean isPingPong()
	{
		return false;
	}

	@Override
	public void reset()
	{
		this.index = 0;
	}

	@Override
	public int getIndex()
	{
		return this.index;
	}

	@Override
	public void dispose()
	{
		for (GLImage image : this.images)
		{
			image.dispose();
		}
	}
}
