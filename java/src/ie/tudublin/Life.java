package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
	LifeBoard board;

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		board = new LifeBoard(100, this);
		board.randomise();
	}
	
	public void draw() {
		board.render();

	}

	public void keyPressed() { 
		if (keyCode == ' ') {
			board.pause();
		}

		if (keyCode == '1') {
			board.randomise();
		}

		if (keyCode == '2')  {
			board.clear();
		}

		if (keyCode == '3') {
			board.drawCross();
		}
	}
}
