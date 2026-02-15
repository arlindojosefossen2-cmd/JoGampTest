package br.com.jogamptest.main;

public interface Scene
{
	void start();
	void input();
	void update();
	void draw(GL2Graphics graphics);
	void stop();
}
