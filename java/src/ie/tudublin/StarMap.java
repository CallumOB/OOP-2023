package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet {

    int hCentre, wCentre;

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        colorMode(RGB);
        hCentre = width / 2;
        wCentre = width / 2;
    }

    public void draw() {
        background(0);

        drawGrid();
    }

    public void drawGrid() {
        int border = 50;
        int X1 = 0;
        int Y1 = 0;
        int X2 = width - border;
        int Y2 = height - border;
        int textX = border - 10;
        int textY = border / 2;
        int textX2 = textX - border / 2;
        int textY2 = textY + border / 2;
        int textValue = -5;
        String a;

        stroke(150, 0, 128);
        strokeWeight(2);
        textSize(20);
        textAlign(CENTER);

        for (int i = 1; i <= 11; i++) {
            a = Integer.toString(textValue);
            Y1 = border * i;
            text(a, textX, textY);
            line(X1 + border, Y1, X2, Y1);
            textValue++;
            textX += border + 1;
        }

        Y1 = 0;
        textValue = -5;

        for (int i = 1; i <= 11; i++) {
            a = Integer.toString(textValue);
            X1 = border * i;
            text(a, textX2, textY2);
            line(X1, Y1 + border, X1, Y2);
            textValue++;
            textY2 += border + 1;
        }
    }
}