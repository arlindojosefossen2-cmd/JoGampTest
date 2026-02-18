package br.com.jogamptest.main;


public final class TestScene implements Scene
{
	public final Game game;
	private final IGameObject player ;

	public TestScene(Game game)
	{
		this.game = game;
		this.player = new Player(game,0,0);
	}

	@Override
	public void start()
	{
		player.start();
	}

	@Override
	public void input(float delta)
	{
		player.input(delta);
	}

	@Override
	public void update(float delta)
	{
		player.update(delta);
	}

	@Override
	public void draw(GL2Graphics graphics)
	{
		if(graphics != null)
		{
			player.draw(graphics);
		}
	}

	@Override
	public void stop()
	{
		player.dispose();
	}
}
