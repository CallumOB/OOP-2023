package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector position;
    private float rotation;
    private int colour;
    private float size;
    PApplet p;

    public Ship(float x, float y, float size, int colour, PApplet p) {
        position = new PVector(x, y);
        this.size = size;
        this.colour = colour;
        this.p = p;
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
