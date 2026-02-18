package br.com.jogamptest.main;

public interface IAnimation
{
	void update(float delta);
	void draw(GL2Graphics graphics,float xPos,float yPos,float rotation);
	boolean isFinished();
	boolean isLooping();
	boolean isPingPong();
	void reset();
	int getIndex();
	void dispose();
}
