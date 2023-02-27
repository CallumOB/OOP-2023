package ie.tudublin;

import ddf.minim.*;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    float[] lerpedBuffer;
    FFT fft;
    
    public void settings() {
        size(1024, 800);
    }
    
    public void setup() {
        colorMode(HSB);
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];
        fft = new FFT(width, 44100);
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
        } // end for 

        fft.forward(ab);
        stroke(255);
        int highest = 0;
        for (int i = 0; i < fft.specSize() / 2; i++) {
            line(i * 2, height, i * 2, height - fft.getBand(i) * 5.0f);
            if (fft.getBand(i) > highest) {
                highest = i;
            }
        }
        float freq = fft.indexToFreq(highest);
        fill(255);
        text("Freq: " + freq, 10, 50);
    }

    float map1(float a, float b, float c, float d, float e) {
        float percent = (c - b) / a;
        float result = e - d; 

        return result + (result / percent);
    }
}
