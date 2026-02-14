package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;

public final class GL2Graphics
{
	private GL2Graphics()
	{

	}

	public static void fillRect(GL2 gl2,GL2Color color,float x,float y,float width,float height)
	{
		if(gl2 != null)
		{
			gl2.glColor4f(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());

			gl2.glBegin(GL2.GL_QUADS);
				gl2.glVertex2f(x,y);
				gl2.glVertex2f(x+width,y);
				gl2.glVertex2f(x+width,y+height);
				gl2.glVertex2f(x,y+height);
			gl2.glEnd();
		}
	}
	public static void fillRect(GL2 gl2,float x,float y,float width,float height)
	{
		if (gl2 != null)
		{
			gl2.glColor3f(1f, 1f, 1f);

			gl2.glBegin(GL2.GL_QUADS);
				gl2.glVertex2f(x, y);
				gl2.glVertex2f(x + width, y);
				gl2.glVertex2f(x + width, y + height);
				gl2.glVertex2f(x, y + height);
			gl2.glEnd();
		}
	}
	public static void drawRect(GL2 gl2,GL2Color color,float x,float y,float width,float height)
	{
		if(gl2 != null)
		{
			gl2.glColor4f(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());

			gl2.glBegin(GL2.GL_LINE_LOOP);
				gl2.glVertex2f(x,y);
				gl2.glVertex2f(x+width,y);
				gl2.glVertex2f(x+width,y+height);
				gl2.glVertex2f(x,y+height);
			gl2.glEnd();
		}
	}

	public static void fillRect (GL2 gl2,GL2Color color, float x, float y, float width, float height, float rotation)
	{
		if(gl2 != null)
		{
			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glColor4f(color.getRed(), color.getGreen(), color.getBlue(),color.getAlpha());

			gl2.glBegin(GL2.GL_QUADS);
				gl2.glVertex2f(-width / 2, -height / 2);
				gl2.glVertex2f(width / 2, -height / 2);
				gl2.glVertex2f(width / 2, height / 2);
				gl2.glVertex2f(-width / 2, height / 2);
			gl2.glEnd();
			gl2.glFlush();

			gl2.glRotatef(rotation, 0, 0, 1);
			gl2.glTranslatef(-x, -y, 0);
		}
	}
}
