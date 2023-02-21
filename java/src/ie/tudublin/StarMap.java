package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    public float border;
    ArrayList<Star> stars = new ArrayList<Star>();
    Star first = null, second = null;

    public void settings() {
        size(600, 600);
    }
    
    public void setup() {
        colorMode(RGB);
        loadStars(); // Accesses the CSV containing the stars and loads them into the 'stars' array list.
        printStars(); // Prints information about the stars in the console.
    
        border = width * 0.1f;
    }

    public void draw() {
        background(0);

        drawGrid(); 
        drawStars(); // Calls a function within the Star class which calls the stars on the grid.

        // The distance can only be checked between two stars if a valid star is clicked.
        if (first != null) 
        {

            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            // Distance can only be calculated if the second star is valid.
            if (second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);

                stroke(255, 255, 0);
                line(x, y, x2, y2);

                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());

                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, mouseX, mouseY);
            }
        }
    }

    /*  When a star is clicked, it is saved within the 'first' variable.
        If a second star is selected, it is stored in the 'second' variable.
        Otherwise, the values for each will stay null. The draw() method then finds 
        the distance between the two. */
    public void mouseClicked() {
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            // A safety margin is added so the user doesn't have to be exact when clicking.
            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
    }

    public void drawGrid() {
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for(int i = -5; i <=5; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    // Loads stars from the CSV file into the 'stars' array list.
    void loadStars() {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for (TableRow r : table.rows()) {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    void printStars() {
        for (Star s:stars) {
            System.out.println(s);
        }
    }

    public void drawStars()
    {
        for(Star s:stars)
        {
            s.render(this);
        }
    }

}