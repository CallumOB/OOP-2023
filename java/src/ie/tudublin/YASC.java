package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class YASC extends PApplet
{
	public boolean[] keys = new boolean[1024]; 

	public void keyPressed()
	{
		keys[keyCode] = true;
	}

	public void keyReleased()
	{
		keys[keyCode] = false;
	}

	// Generic
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public ArrayList<GameObject> game = new ArrayList<GameObject>();


	public void settings()
	{
		size(500, 500);

		PVector a = new PVector(10, 10);
        PVector b = new PVector(20, 20);

        b = a;
        
        b.x = 30;
        b.y = 30;

        println(a);
		
	}

	String s3 = "Hello";

	public void setup() {
		Ship ship = new Ship(width / 2, height / 2, 50, 70, this);
		Ship ship1 = new Ship(100, 50, 80, 6, this);
		colorMode(HSB);

		game.add(ship);
		game.add(ship1);

		String s = "I love Star Trek";

		s += " & 200AD";

		String s1 = s.substring(2, 6);

		println(s.substring(7, 11));

		println(s.indexOf("Trek"));

		println(s.startsWith("Ilove"));

		String ss3 = "Hell";
		String temp = "o";
		String s2 = "Hello";
		
		String s4 = ss3 + temp;

		println(s4 == s2);
		println(s4.equals(s2));
		


		println();

		/*startsWith
		endsWidth
		substring
		indexOf
		s1.chatAt
		s1.lastIndexOf
		s1.toUpperCase()
		s1.compareTo(s)
		s1.equals
		s1.

		println(s1);
		*/
	}

	public void draw()
	{	background(0);

		for(int i = game.size() - 1 ; i >= 0 ; i --)
		{
			GameObject b = game.get(i);
			b.render();
			b.move();
		}

		fill(255);
		text("Game Objects: " + game.size(), 50, 50);

	}
}
