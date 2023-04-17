package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship extends GameObject{

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        super(x, y, 0, c, p);
        this.size = size;
        halfSize = size / 2;
    }

    private float size;
    private float halfSize;

    int fireRate = 5;

    int toPass = 1000 / fireRate;
    int ellapsed = 1000;
    int health = 100;

    public void checkCollisions() {
        for (int i = ((YASC) p).game.size() - 1; i >= 0; i--) {
            GameObject go = ((YASC) p).game.get(i);

            if (PVector.dist(go.pos, pos) < halfSize && go instanceof Bullet) {
                health--;
                ((YASC) p).game.remove(go);
            }
        }
    }

    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = - PApplet.cos(rot);

        YASC yasc= ((YASC)p);
        

        if (yasc.keys[PApplet.LEFT])
        {
            rot -= 0.1f;
        }

        if (yasc.keys[PApplet.RIGHT])
        {
            rot += 0.1f;
        }

        if (yasc.keys[PApplet.UP])
        {
            pos.x += forward.x;
            pos.y += forward.y;
        }

        if (yasc.keys[PApplet.DOWN])
        {
            pos.x -= forward.x;
            pos.y -= forward.y;
        }
        if (yasc.keys[' '] && ellapsed >= toPass)
        {
            ellapsed = 0;
            PVector inFront = PVector.add(pos,
                PVector.mult(forward, 30)
                );  
            
            Bullet b = new Bullet(inFront.x, inFront.y, rot, c, p);

            ((YASC)p).game.add(b);
        }
        int now = p.millis();
        timeDelta = now - last;
        ellapsed += timeDelta;
        last = now;

    }
    int last = 0;
    int timeDelta;

    public void render()
    {
        checkCollisions();
        p.pushMatrix();
        p.translate(pos.x, pos.y);

        p.fill(255);
        p.text("Health :" + health, 50, 0);
        p.noFill();

        p.rotate(rot);
        p.stroke(c, 255, 255);
        p.line(- halfSize, halfSize, 0, - halfSize);
        p.line(0, - halfSize, halfSize, + halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, -halfSize, halfSize);
        p.popMatrix();
    }

    
    
}
