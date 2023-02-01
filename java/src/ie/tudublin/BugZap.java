package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
    
    public void settings() {
        size(800, 500);
        playerX = width / 2;
        playerY = height / 2;
        laserX = width / 2;
        laserY = height;

        System.out.println(width);
    }
    
    public void setup() {
        background(0);
    }
    
    public void drawPlayer(float x, float y, float w) {
        // float h = w / 2;

        stroke(127);
        line(x - 50, y + w, x + 50, y + w);
    }
    
    public void draw() {
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            System.out.println("Left Arrow Pressed");
            if (playerX > 60) {
                playerX -= 15;
            }
        }
        if (keyCode == RIGHT) {
            System.out.println("Right Arrow Pressed");
            if (playerX < width - 60) {
                playerX += 15;
            }
        }
        if (key == ' ') {
            line(playerX, laserY - 125, playerX, laserY - 450);
            System.out.println("SPACE key pressed");
        }
    }
    
    float playerX;
    float playerY;
    float laserX;
    float laserY;
    float playerWidth = 150;
}
