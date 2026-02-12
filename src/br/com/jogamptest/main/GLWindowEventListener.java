package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class GLWindowEventListener implements GLEventListener
{
	@Override
	public void init(GLAutoDrawable glAutoDrawable)
	{
		GL2 gl2 = glAutoDrawable.getGL().getGL2();

		gl2.glClearColor(0.2f,0.4f,0.85f,1f);
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void dispose(GLAutoDrawable glAutoDrawable)
	{

	}

	@Override
	public void display(GLAutoDrawable glAutoDrawable)
	{
		GL2 gl2 = glAutoDrawable.getGL().getGL2();

		gl2.glClearColor(0.2f,0.4f,0.85f,1f);
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		gl2.glBegin(GL2.GL_QUADS);
		gl2.glColor3f(0.2f,1f,0.5f);
		gl2.glVertex2f(-0.2f,0.2f);
		gl2.glVertex2f(0.2f,0.2f);
		gl2.glVertex2f(0.2f,-0.2f);
		gl2.glVertex2f(-0.2f,-0.2f);
		gl2.glEnd();
	}

	@Override
	public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3)
	{

	}
}
