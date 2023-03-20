package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector position;
    private PVector forward;
    private float rotation;
    private int colour;
    private float size;
    private float halfSize;
    PApplet p;

    public Ship(float x, float y, float size, int colour, PApplet p) {
        position = new PVector(x, y);
        forward = new PVector(0, -1);
        this.size = size;
        this.colour = colour;
        this.p = p;
        this.halfSize = size / 2;
    }

    public void move() {
        forward.x = PApplet.sin(rotation);
        forward.y = -PApplet.cos(rotation);
        
        if (p.keyPressed) {
            if (p.keyCode == PApplet.LEFT) {
                rotation -= 0.1f;
            }
            if (p.keyCode == PApplet.RIGHT) {
                rotation += 0.1f;
            }
            if (p.keyCode == PApplet.UP) {
                position.x += forward.x;
                position.y += forward.y;
            }
            if (p.keyCode == PApplet.DOWN) {
                position.x -= forward.x;
                position.y -= forward.y;
            }
        }
    }

    public void render() {
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.rotate(rotation);
        p.stroke(colour, 255, 255);
        p.line(0 - halfSize, 0 + halfSize, 0, 0 - halfSize);
        p.line(0, 0 - halfSize, 0 + halfSize, 0 + halfSize);
        p.line(0 + halfSize, 0 + halfSize, 0, 0);
        p.line(0, 0, 0 - halfSize, 0 + halfSize);
        p.popMatrix();
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

}
