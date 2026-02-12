package br.com.jogamptest.main;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class GameMouseListener implements MouseListener
{
	@Override
	public void mouseClicked(MouseEvent mouseEvent)
	{
		System.out.println("Clicked: "+mouseEvent.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent)
	{
		System.out.println("Mouse Entered");
	}

	@Override
	public void mouseExited(MouseEvent mouseEvent)
	{
		System.out.println("Mouse Exite");
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{
		System.out.println("Pressed: "+mouseEvent.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{
		System.out.println("Release: "+mouseEvent.getButton());
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent)
	{
		System.out.println("Mouse Moved");
	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent)
	{
		System.out.println("Mouse Dragged");
	}

	@Override
	public void mouseWheelMoved(MouseEvent mouseEvent)
	{
		System.out.println("Mouse Wheel: (x = "+mouseEvent.getX()+", y = "+mouseEvent.getY());
	}
}