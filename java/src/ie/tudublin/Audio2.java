package ie.tudublin;

import ddf.minim.*;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    float[] lerpedBuffer;
    
    public void settings() {
        size(1024, 800);
    }

    public void setup() {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];
    }

    public void draw() {
        background(0);
        stroke(255);
        float half = height / 2;
        
        for (int i = 0; i < ab.size(); i++) {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            float f = abs(lerpedBuffer[i] * half);
            line(i, half + f, i, half - f);
        }

        println(map(5, 0, 10, 1000, 2000));
        println(map1(5, 0, 10, 1000, 2000));
    }

    float map1(float a, float b, float c, float d, float e) {
        float percent = (c - b) / a;
        float result = e - d; 

        return result + (result / percent);
    }
}
