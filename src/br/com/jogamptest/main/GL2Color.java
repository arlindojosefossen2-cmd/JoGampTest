package br.com.jogamptest.main;

public final class GL2Color
{
	private float red;
	private float green;
	private float blue;
	private float alpha;

	public GL2Color(float red,float green,float blue,float alpha)
	{
		this.clamp(red,green,blue,alpha);
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

	public float getAlpha()
	{
		return alpha;
	}
	public void clamp(float red,float green,float blue,float alpha)
	{
		this.red = Math.max(0,Math.min(1,red));
		this.green = Math.max(0,Math.min(1,green));
		this.blue = Math.max(0,Math.min(1,blue));
		this.alpha = Math.max(0,Math.min(1,alpha));
	}
}
