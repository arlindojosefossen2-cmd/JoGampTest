package br.com.jogamptest.main;

public final class IntColor
{
	private short red;
	private short green;
	private short blue;
	private short alpha;

	public IntColor(int red,int green,int blue,int alpha)
	{
		this.clamp(red,green,blue,alpha);
	}

	public short getRed()
	{
		return red;
	}

	public short getGreen()
	{
		return green;
	}

	public short getBlue()
	{
		return blue;
	}

	public short getAlpha()
	{
		return alpha;
	}

	public void clamp(int red, int green, int blue, int alpha)
	{
		this.red = (short) Math.max(0,Math.min(255,red));
		this.green = (short) Math.max(0,Math.min(255,green));
		this.blue = (short) Math.max(0,Math.min(255,blue));
		this.alpha = (short) Math.max(0,Math.min(255,alpha));
	}
}
