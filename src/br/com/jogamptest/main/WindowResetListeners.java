package br.com.jogamptest.main;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;

public class WindowResetListeners extends WindowAdapter
{
	@Override
	public void windowLostFocus(WindowEvent windowEvent)
	{
		System.out.println("Lost Focus Reset Listeners");
	}
}
