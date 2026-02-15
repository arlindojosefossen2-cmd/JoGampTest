package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.awt.*;

public class GLWindowEventListener implements GLEventListener
{
	public static GL2 gl2;
	private final GL2Graphics graphics;
	private final Game game;

	public GLWindowEventListener(Game game,GL2Graphics graphics)
	{
		this.graphics = graphics;
		this.game = game;
	}

	@Override
	public void init(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		staff(gl2);
		game.currentScene.start();
	}

	private void staff(GL2 gl2)
	{
		gl2.glClearColor(0.2f,0.4f,0.85f,1f);
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
	}

	@Override
	public void dispose(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 != null)
		{
			gl2.glFinish();
		}

		game.currentScene.stop();
	}

	@Override
	public void display(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		staff(gl2);

		game.currentScene.draw(graphics);
	}

	@Override
	public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		gl2.glMatrixMode(GL2.GL_PROJECTION_MATRIX);
		gl2.glLoadIdentity();

		float units = height / ((float) width / Game.UNITS) / 2;

		gl2.glOrtho( -Game.UNITS /2f, Game.UNITS /2f,-units,units,-1,1);
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
	}
}
