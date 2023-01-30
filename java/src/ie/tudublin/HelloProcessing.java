package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		// colorMode(HSB);
		background(255, 0, 0);

		
		
	}
	
	public void draw()
	{	
		// stroke(255);
		// line(10, 10, 100, 100); // X1, Y1, X2, Y2
		// fill(255, 255, 0);
		// circle(300, 250, 70); // Position (X, Y), Size
		// fill(255, 0, 255);
		// noStroke();
		// rect(10, 300, 20, 100); // X1, Y1, width, height
		// stroke(127);
		// fill(0, 0, 237);
		// triangle(40, 90, 300, 20, 80, 70);

		noStroke();
		
		fill(255, 255, 0);
		circle(width / 2, (height / 2) + 15, width - 30);
		fill(0, 255, 255);
		triangle(30, 450, width / 2 , 10, width - 30, 450);
		fill(255);
		ellipse((width / 2), (height / 2) - 50, 185, 100);
		fill(0);
		circle((width / 2), (height / 2) - 50, mouseX / 2);
	}
}
