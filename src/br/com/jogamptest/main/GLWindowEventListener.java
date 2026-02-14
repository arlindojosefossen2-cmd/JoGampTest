package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class GLWindowEventListener implements GLEventListener
{
	private GL2 gl2;

	//test
	private final GL2Color color = new GL2Color(0.7f,0.6f,0.3f,1f);
	private final GL2Color color2 = new GL2Color(.0f,.07f,.03f,1f);
	private final GL2Color color3 = new GL2Color(.8f,.9f,.2f,1f);

	@Override
	public void init(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		staff(gl2);
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
	}

	@Override
	public void display(GLAutoDrawable glAutoDrawable)
	{
		if(gl2 == null)
		{
			gl2 = glAutoDrawable.getGL().getGL2();
		}

		staff(gl2);

		GL2Graphics.fillRect(gl2,1.5f,1.5f,1f,1f);

		GL2Graphics.fillRect(gl2,color3,.5f,1,1,1);
		GL2Graphics.drawRect(gl2,color2,1,1,1,1);

		GL2Graphics.fillRect(gl2,color,0.8f,1,1,1,45);
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
