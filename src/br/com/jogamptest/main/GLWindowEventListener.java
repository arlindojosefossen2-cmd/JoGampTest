package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.awt.*;

public class GLWindowEventListener implements GLEventListener
{
	private static GL2 gl2;
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
		gl2.glClearColor(0f,1f,1f,1f);
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

		gl2.glTranslatef(-game.camera.x,-game.camera.y,0);

		game.currentScene.draw(graphics);

		gl2.glTranslatef(game.camera.x,game.camera.y,0);
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

	public static GL2 getGl2()
	{
		return gl2;
	}
}
