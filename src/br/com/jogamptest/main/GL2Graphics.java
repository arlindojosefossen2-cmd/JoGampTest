package br.com.jogamptest.main;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public final class GL2Graphics
{
	private GL2 gl2;

	public GL2Graphics()
	{

	}

	public void drawRect(FloatColor color, float x, float y, float width, float height)
	{
		drawRect(color,x,y,width,height,0);
	}

	public void drawRect(FloatColor color, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.getGl2() != null)
		{
			gl2 = GLWindowEventListener.getGl2();
		}

		if(gl2 != null)
		{
			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glColor4f(color.red, color.green, color.blue,color.alpha);

			gl2.glBegin(GL2.GL_LINE_LOOP);
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

	public void fillRect(FloatColor color, float x, float y, float width, float height)
	{
		fillRect(color,x,y,width,height,0);
	}
	public void fillRect(FloatColor color, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.getGl2() != null)
		{
			gl2 = GLWindowEventListener.getGl2();
		}

		if(gl2 != null)
		{
			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glColor4f(color.red, color.green, color.blue,color.alpha);

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

	public void drawRect(IntColor color, float x, float y, float width, float height)
	{
		drawRect(color,x,y,width,height,0);
	}

	public void drawRect(IntColor color, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.getGl2() != null)
		{
			gl2 = GLWindowEventListener.getGl2();
		}

		if(gl2 != null)
		{
			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glColor4f(color.red, color.green, color.blue,color.alpha);

			gl2.glBegin(GL2.GL_LINE_LOOP);
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

	public void fillRect(IntColor color, float x, float y, float width, float height)
	{
		fillRect(color,x,y,width,height,0);
	}
	public void fillRect(IntColor color, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.getGl2() != null)
		{
			gl2 = GLWindowEventListener.getGl2();
		}

		if(gl2 != null)
		{
			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glColor4f(color.red, color.green, color.blue,color.alpha);

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
	public void drawTexture(Texture texture, float x, float y, float width, float height)
	{
		drawTexture(texture,x,y,width,height,0);
	}

	public void drawTexture(Texture texture, float x, float y, float width, float height, float rotation)
	{
		if(GLWindowEventListener.getGl2() != null)
		{
			gl2 = GLWindowEventListener.getGl2();
		}

		if(gl2 != null && texture != null)
		{
			gl2.glBindTexture(GL2.GL_TEXTURE_2D,texture.getTextureObject());

			gl2.glTranslatef(x, y, 0);
			gl2.glRotatef(-rotation, 0, 0, 1);

			gl2.glEnable(GL2.GL_TEXTURE_2D);
			gl2.glEnable(GL2.GL_BLEND);
			gl2.glBlendFunc(GL2.GL_SRC_ALPHA,GL2.GL_ONE_MINUS_SRC_ALPHA);

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

			gl2.glDisable(GL2.GL_TEXTURE_2D);
			gl2.glDisable(GL2.GL_BLEND);
			gl2.glBlendFunc(0,0);

			gl2.glRotatef(rotation, 0, 0, 1);
			gl2.glTranslatef(-x, -y, 0);
		}
	}
}
