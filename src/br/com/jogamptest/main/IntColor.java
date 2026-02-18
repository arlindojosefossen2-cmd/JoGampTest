package br.com.jogamptest.main;

public final class IntColor
{
	public final short red;
	public final short green;
	public final short blue;
	public final short alpha;

	public IntColor(int red,int green,int blue,int alpha)
	{
		this.red = (short) Math.max(0,Math.min(255,red));
		this.green = (short) Math.max(0,Math.min(255,green));
		this.blue = (short) Math.max(0,Math.min(255,blue));
		this.alpha = (short) Math.max(0,Math.min(255,alpha));
	}
}
