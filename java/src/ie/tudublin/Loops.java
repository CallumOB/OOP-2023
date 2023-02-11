package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    int mode = -1;
    int wCentre;
    int hCentre;
    
    public void settings() {
        size(500, 500);
        wCentre = width / 2;
        hCentre = height / 2;
    }

    public void setup() {
        colorMode(HSB);
    }
    
    public void draw() {
        background(0);
        noStroke();
        fill(140, 255, 255);

        switch (mode) {
            case(0): {
                ifStatement();
                break;
            }

            case(1): {
                colourSpectrum();
                break;
            }

            case(2): {
                squares();
                break;
            }

            case(3): {
                doubleSquares();
                break;
            }

            case(4): {
                expandingCircle();
                break;
            }
            
            case(5): {
                smallCircles();
                break;
            }

            case(6): {
                circleFill();
                break;
            }

            case(7): {
                grid();
                break;
            }

            case(8): {
                blueSquares();
                break;
            }

            case(9): {
                star();
                break;
            }

            default: {
                shapes();
                break;
            }
        }
    }

    public void ifStatement() {
        int rectX = 150;
        int rectY = 200;
        if (mouseY < hCentre) {
            rectY = -rectY;
        }

        if (mouseX > wCentre) {
            rect(wCentre, hCentre, rectX, rectY);
        }

        if (mouseX < wCentre) {
            rect(wCentre - rectX, hCentre, rectX, rectY);
        }
    }

    public void colourSpectrum() {
        int X1 = 0;
        int Y1 = 0;
        int X2 = X1 + 50;
        int Y2 = height;
        int colour = 255;
        
        for (int i = 0; i < width / 50; i++) {
            fill(colour % 255, 255, 255);
            rect(X1, Y1, X2, Y2);
            X1 += 50;
            colour += 25;
        }
    }

    public void squares() {
        int X1 = 0;
        int Y1 = 0;
        int X2 = X1 + 50;
        int Y2 = Y1 + 50;
        int colour = 255;

        for (int i = 0; i < 10; i++) {
            fill(colour % 255, 255, 255);
            rect(X1, Y1, X2, Y2);
            X1 += 50;
            Y1 += 50;
            colour += 25;
        }
    }

    public void doubleSquares() {
        int X1 = 0;
        int Y1 = 0;
        int X2 = X1 + 50;
        int Y2 = Y1 + 50;
        int colour = 255;

        for (int i = 0; i < width / 50; i++) {
            fill(colour % 255, 255, 255);
            rect(X1, Y1, X2, Y2);
            X1 += 50;
            // The second array of squares are drawn from the opposite side of the canvas, minus the value of X1.
            // This means they will be drawn opposite the first array.
            rect(width - X1, Y1, X2, Y2);
            Y1 += 50;
            colour += 25;
        }
    }

    public void expandingCircle() {
        int colour = 255;
        int circleSize = width;
        for (int i = 0; i < width / 50; i++) {
            fill(colour % 255, 255, 255);
            ellipse(wCentre, hCentre, circleSize, circleSize);
            colour += 25;
            circleSize -= 50;
        }
    }

    public void smallCircles() {
        int colour = 255;
        int circleSize = 50;
        int X = circleSize / 2;
        int Y = circleSize / 2;

        for (int i = 0; i < width / 10; i++) {
            fill(colour % 255, 255, 255);
            ellipse(X, Y, circleSize, circleSize);
            colour += 25;
            X += circleSize;
        }
    }

    public void circleFill() {
        int X;
        int colour = 255;
        int circleSize = 50;
        int Y = circleSize / 2;
        for (int i = 0; i < width / 50; i++) {
            X = circleSize / 2;

            for (int j = 0; j < width / 50; j++) {
                fill(colour % 255, 255, 255);
                ellipse(X, Y, circleSize, circleSize);
                X += circleSize;
                colour += 25;
            }
            
            colour += 25;
            Y += circleSize;
        }  
    }

    public void grid() {
        stroke(120, 255, 255);
        noFill();
        int offset = 50;
        int textvalue = -5;
        int lineX = offset;
        int lineY = offset;
        int textX = offset; 
        int textY = 25;
        int textX2 = textX;
        int textY2 = textY + offset / 2;
        int translate = 40;
        textSize(25);
        String a;

        rect(offset, offset, width - offset * 2, height - offset * 2);
        textAlign(CENTER);
        
        for (int i = 0; i <= 10; i++) {
            a = Integer.toString(textvalue);
            text(a, textX, textY);
            text(a, textX2 - 30, textY2);
            textvalue++;
            // Separate X and Y values are used for the two lines of text as they are being translated in different directions.
            textX += translate;
            textY2 += translate;

            // Due to the text being incremented, the loop runs one too many times for the lines being drawn, hence the if-statement.
            if (textvalue < 5) {
                line(offset, lineY + translate, offset + (width - offset * 2), lineY + translate);
                line(lineX + translate, offset, lineX + translate, offset + (height - offset * 2));
                lineX += translate;
                lineY += translate;
            }
        }
    }

    public void blueSquares() {
        int X1 = 0;
        int Y1 = 0;
        int X2 = X1 + 50;
        int Y2 = Y1 + 50;
        int colour_switch = 1;

        for (int i = 0; i < width / 50; i++) {
            X1 = 0;
            colour_switch++;
            for (int j = 0; j < width / 50; j++) {
                if (colour_switch % 2 == 1) {
                    fill(140, 255, 255);
                } else {
                    fill(140, 100, 255);
                }

                rect(X1, Y1, X2, Y2);
                X1 += 50;
                colour_switch++;
            }
            Y1 += 50;
        }
    }

    public void star() {
        float angle = TWO_PI / 5;
        float length = 150;
        float rotation = HALF_PI + angle / 2;
        int x = wCentre;
        int y = hCentre;

        background(255);
        stroke(0);

        for (float a = 0; a < TWO_PI; a += angle) {
            float endX = x + cos(a + rotation) * length;
            float endY = y + sin(a + rotation) * length;
            line(x, y, endX, endY);
        }
    }

    public void shapes() {
        float angle = TWO_PI / 5;
        float radius = 150;
        int x = wCentre;
        int y = hCentre;
        stroke(255);

        for (float a = 0; a < TWO_PI; a += angle) {
            float startX = x + cos(a + angle / 2 + PI / 2) * radius;
            float startY = y + sin(a + angle / 2 + PI / 2) * radius;
            float endX = x + cos(a + angle + angle / 2 + PI / 2) * radius;
            float endY = y + sin(a + angle + angle / 2 + PI / 2) * radius;
            line(startX, startY, endX, endY);
        }
    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '9') {
            mode = Character.getNumericValue(keyCode);
        } 
    }

}
