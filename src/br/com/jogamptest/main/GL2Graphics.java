package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public final class GL2Graphics
{
	private GL2 gl2;

	public GL2Graphics()
	{

	}

	public void fillRect(GL2Color color,float x,float y,float width,float height)
	{
		if(GLWindowEventListener.gl2 != null)
		{
			gl2 = GLWindowEventListener.gl2;
		}

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
	public void drawRect(GL2Color color,float x,float y,float width,float height)
	{
		if(GLWindowEventListener.gl2 != null)
		{
			gl2 = GLWindowEventListener.gl2;
		}

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

	public void fillRect(GL2Color color, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.gl2 != null)
		{
			gl2 = GLWindowEventListener.gl2;
		}

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

	public void drawTexture(Texture texture, GL2Color color, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.gl2 != null)
		{
			gl2 = GLWindowEventListener.gl2;
		}

		if(gl2 != null && texture != null)
		{
			gl2.glBindTexture(GL2.GL_TEXTURE_2D,texture.getTextureObject());

			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glColor4f(color.getRed(), color.getGreen(), color.getBlue(),color.getAlpha());

			gl2.glBegin(GL2.GL_QUADS);
				gl2.glTexCoord2f(0,1);
				gl2.glVertex2f(-width / 2, -height / 2);
				gl2.glTexCoord2f(1,1);
				gl2.glVertex2f(width / 2, -height / 2);
				gl2.glTexCoord2f(1,0);
				gl2.glVertex2f(width / 2, height / 2);
				gl2.glTexCoord2f(0,0);
				gl2.glVertex2f(-width / 2, height / 2);
			gl2.glEnd();
			gl2.glFlush();

			gl2.glBindTexture(GL2.GL_TEXTURE_2D,0);

			gl2.glRotatef(rotation, 0, 0, 1);
			gl2.glTranslatef(-x, -y, 0);
		}
	}
}
