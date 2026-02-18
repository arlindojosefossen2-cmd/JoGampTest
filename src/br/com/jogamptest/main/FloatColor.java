package br.com.jogamptest.main;

public final class FloatColor
{
	public final float red;
	public final float green;
	public final float blue;
	public final float alpha;

	public FloatColor(float red, float green, float blue, float alpha)
	{
		this.red = Math.max(0,Math.min(1,red));
		this.green = Math.max(0,Math.min(1,green));
		this.blue = Math.max(0,Math.min(1,blue));
		this.alpha = Math.max(0,Math.min(1,alpha));
	}
}
