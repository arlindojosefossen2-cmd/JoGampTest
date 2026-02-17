package br.com.jogamptest.main;

public final class FrameRate
{
	private String frameRate;
	private long lasTime;
	private long delta;
	private int frameCounter;

	public void initialize()
	{
		lasTime = System.currentTimeMillis();
		frameRate = "";
	}

	public void calculate()
	{
		long current = System.currentTimeMillis();
		delta += current - lasTime;
		lasTime = current;

		frameCounter++;

		if(delta > 1000)
		{
			delta -= 1000;
			frameRate = String.format("%s FPS", frameCounter);
			frameCounter = 0;
		}
	}

	public String getFrameRate()
	{
		return frameRate;
	}
}
