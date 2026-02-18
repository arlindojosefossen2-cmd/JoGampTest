package br.com.jogamptest.main;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

import java.awt.*;
import java.util.Arrays;

public class GameMouseListener implements MouseListener
{
	private static final int BUTTON_COUNT = 3;

	private Point mousePosition;
	private Point currentPosition;

	private final boolean[] mouse;
	private final int[] polled;

	private float notches;
	private float polledNotches;

	private int buttonPressed;
	private int buttonRelease;

	private final Game game;

	public GameMouseListener(Game game)
	{
		this.game = game;
		mousePosition = new Point();
		currentPosition = new Point();

		mouse = new boolean[BUTTON_COUNT];
		polled = new int[BUTTON_COUNT];
	}

	public synchronized void pollEvent()
	{
		mousePosition = currentPosition;

		polledNotches = notches;
		notches = 0;

		for (int i = 0; i < mouse.length; i++)
		{
			if (mouse[i])
			{
				polled[i]++;
			}
			else
			{
				polled[i] = 0;
			}
		}
	}
	public Point getMousePosition()
	{
		return mousePosition;
	}
	public float getNotches()
	{
		return polledNotches;
	}

	public boolean isButtonDown(int keyButton)
	{
		return (polled[keyButton-1] > 0);
	}

	public boolean isButtonDownOnce(int keyButton)
	{
		return (polled[keyButton-1] == 1);
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent)
	{

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent)
	{
		mouseMoved(mouseEvent);
	}

	@Override
	public void mouseExited(MouseEvent mouseEvent)
	{
		mouseMoved(mouseEvent);
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{
		buttonPressed = mouseEvent.getButton()-1;

		if(buttonPressed >= 0 && buttonPressed < mouse.length)
		{
			mouse[buttonPressed] = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{
		buttonRelease = mouseEvent.getButton()-1;

		if (buttonRelease >= 0 && buttonRelease < mouse.length)
		{
			mouse[buttonRelease] = false;
		}
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent)
	{
		currentPosition.setLocation(mouseEvent.getX(),mouseEvent.getY());
	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent)
	{
		mouseMoved(mouseEvent);
	}

	@Override
	public void mouseWheelMoved(MouseEvent mouseEvent)
	{
		//code to modify
		for (int i = 0; i < mouseEvent.getRotation().length; i++)
		{
			notches += mouseEvent.getRotation()[i];
		}
	}

	public float worldX()
	{
		return (float) Game.UNITS /game.getHeight()*currentPosition.x - (float) Game.UNITS /2+game.camera.x;
	}
	public float worldY()
	{
		float tallUnits = (float) Game.UNITS*game.getHeight()/game.getWidth();
		return tallUnits/game.getHeight()*currentPosition.y - tallUnits/2 + game.camera.y;
	}

	public void reset()
	{
		Arrays.fill(mouse,false);
		Arrays.fill(polled,0);

		mousePosition = new Point();
		currentPosition = new Point();

		notches = 0;
		polledNotches = 0;

		buttonRelease = 0;
		buttonPressed = 0;
	}
}