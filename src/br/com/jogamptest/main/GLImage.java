package br.com.jogamptest.main;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static javax.imageio.ImageIO.*;

public class GLImage
{
	private final Texture texture;
	private final int width;
	private final int height;

	public GLImage(String filepath)
	{
		try
		{
			BufferedImage image = read(Objects.requireNonNull(GLImage.class.getResourceAsStream(filepath)));
			image.flush();

			width = image.getWidth()/Game.UNITS/2;
			height = image.getHeight()/Game.UNITS/2;
			texture = AWTTextureIO.newTexture(Game.getProfile(), image,true);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public Texture getTexture()
	{
		return texture;
	}

	public void dispose()
	{
		texture.destroy(GLWindowEventListener.gl2);
	}
}
