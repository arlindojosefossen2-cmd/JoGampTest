package br.com.jogamptest.main;

public final class TestGame extends Game
{
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 576;

	public static final int GAME_FPS = 60;
	public static final String GAME_TITLE = "JOGL-GAME-TESTING";

	private TestGame(String title, int width, int heigh)
	{
		super(title, width, heigh);
	}

	public static void main(String[] args)
	{
		Game game = new TestGame(GAME_TITLE, WIDTH, HEIGHT);
		game.addScene(new TestScene(game));

		Game.launch(game,GAME_FPS,true);
	}
}
