package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class GLWindowEventListener implements GLEventListener
{
	private GL2 gl2;

	@Override
	public void init(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		gl2.glClearColor(0.2f,0.4f,0.85f,1f);
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void dispose(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 != null)
		{
			gl2.glFinish();
		}
	}

	@Override
	public void display(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		gl2.glClearColor(0.2f,0.4f,0.85f,1f);
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		gl2.glColor3f(1f,1f,0.5f);
		gl2.glBegin(GL2.GL_QUADS);
			gl2.glVertex2f(-0.1f,0.1f);
			gl2.glVertex2f(0.1f,0.1f);
			gl2.glVertex2f(0.1f,-0.1f);
			gl2.glVertex2f(-0.1f,-0.1f);
		gl2.glEnd();
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

		float units = (float) Main.HEIGHT /((float) Main.WIDTH /Main.UNITS);

		gl2.glOrtho( Main.UNITS /2f, Main.UNITS /2f,-units,units,-1,1);
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
	}
}
