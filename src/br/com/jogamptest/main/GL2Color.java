package br.com.jogamptest.main;

public final class GL2Color
{
	private final float red;
	private final float green;
	private final float blue;

	public GL2Color(float red,float green,float blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public float getBlue()
	{
		return blue;
	}

	public float getGreen()
	{
		return green;
	}

	public float getRed()
	{
		return red;
	}
}
