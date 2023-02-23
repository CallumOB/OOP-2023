package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void settings() {
        size(1024, 800);
        // fullScreen(P3D, SPAN);
    }

    public void setup() {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix;

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;
    }

    float off = 0;

    public void draw() {
        // background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        float cx = width / 2;
        float cy = height / 2;

        switch (mode) {
            case 0: {
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    // float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, halfH - f, i);
                }
                break;
            }

            case 1: {
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    // float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);
                }
                break;
            } // end case 1

            case 2: {
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * height;
                    line(i, height + f, i, height - f);
                    line(i, f, i, -f);
                    line(width + f, i, width - f, i);
                    line(f, i, -f, i);
                }
                break;
            } // end case 2

            case 3: {
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    float f = ab.get(i) * halfH;
                    stroke(f, 255, 255);
                    fill(0);
                    circle(cx, cy, smoothedAmplitude * height);
                }
                break;
            } // end case 3

            case 4: {
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    float f = ab.get(i) * halfH;
                    stroke(f, 255, 255);
                    fill(0);
                    rectMode(CENTER);
                    rect(cx, cy, smoothedAmplitude * height, smoothedAmplitude * height);
                }
                break;
            } // end case 4

            case 5: {
                float halfW = width / 2;
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    float f = ab.get(i) * halfH;
                    stroke(f, 255, 255);
                    fill(0);
                    line(cx + halfW, halfH + f, cx - halfW, halfH - f);
                    line(f + halfW, halfH + cx, halfW - f, halfH - cx);
                    circle(cx / 2, cy / 2, smoothedAmplitude * height * 2);
                    circle((cx / 2) + halfW, cy / 2, smoothedAmplitude * height * 2);
                    circle(cx / 2, (cy / 2) + halfH, smoothedAmplitude * height * 2);
                    circle((cx / 2) + halfW, (cy / 2) + halfH, smoothedAmplitude * height * 2);
                }
                break;
            } // end case 5
        } // end switch
    } // end draw()
} // end Audio1