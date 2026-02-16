package br.com.jogamptest.main;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;

public class WindowResetListeners extends WindowAdapter
{
	private final Game game;

	public WindowResetListeners(Game game)
	{
		this.game = game;
	}

	@Override
	public void windowLostFocus(WindowEvent windowEvent)
	{
		this.game.input.reset();
		this.game.mouse.reset();
	}
}
