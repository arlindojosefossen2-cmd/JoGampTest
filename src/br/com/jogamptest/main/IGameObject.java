package br.com.jogamptest.main;

public interface IGameObject
{
	void start();
	void input(float delta);
	void update(float delta);
	void draw(GL2Graphics graphics);
	void dispose();
}
