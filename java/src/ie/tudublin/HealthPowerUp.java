package ie.tudublin;

import processing.core.PVector;

public class HealthPowerUp extends GameObject implements PowerUp {

    float w;
    float halfW;

    public HealthPowerUp(float x, float y, float rot, int c, YASC p)  {
        super(x, y, rot, c, p);
        w = 50;
        halfW = w / 2;

        forward.x = p.random(-1, 1);
        forward.y = p.random(-1, 1);
        forward.normalize();
    }

    @Override
    public void applyTo(Ship s) {
        s.health += 10;
        ((YASC) p).gameObjects.remove(this);
    }

    float speed = 0.01f;

    @Override
    public void update() {
        rot += 0.01f;

        pos.add(PVector.mult(forward, speed));

        if (pos.x < 0)
        {
            pos.x = p.width;
        }
        if (pos.y < 0)
        {
            pos.y = p.height;
        }
        if (pos.x > p.width)
        {
            pos.x = 0;
        }

        if (pos.y > p.height)
        {
            pos.y = 0;
        }
    }

    @Override
    public void render() {
        p.pushMatrix();

        p.noFill();
        p.stroke(255);

        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.rectMode(YASC.CENTER);
        p.rect(-halfW, -halfW, w, w);
        p.line(0, -20, 0, 20);
        p.line(-20, 0, 0, 20);
        
        p.popMatrix();
    }
}
