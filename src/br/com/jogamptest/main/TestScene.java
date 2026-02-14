package br.com.jogamptest.main;

public final class TestScene implements Scene
{

	@Override
	public void start()
	{
		System.out.println("start");
	}

	@Override
	public void input()
	{
		System.out.println("input");
	}

	@Override
	public void update()
	{
		System.out.println("update");
	}

	@Override
	public void draw()
	{
		System.out.println("draw");
	}

	@Override
	public void stop()
	{
		System.out.println("stop");
	}
}
