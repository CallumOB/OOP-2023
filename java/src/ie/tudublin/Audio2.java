package ie.tudublin;

import ddf.minim.*;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    
    public void settings() {
        size(1024, 1024);
    }

    public void setup() {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
    }

    public void draw() {
        background(0);
        stroke(255);
        float half = height / 2;
        
        for (int i = 0; i < ab.size(); i++) {
            line(i, half, i, half + ab.get(i) * half);
        }
    }

}
