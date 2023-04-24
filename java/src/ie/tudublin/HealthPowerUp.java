package ie.tudublin;

public class HealthPowerUp extends GameObject implements PowerUp {

    float w;

    public HealthPowerUp(float x, float y, float rot, int c, YASC p)  {
        super(x, y, rot, c, p);
        w = 50;
    }

    @Override
    public void applyTo(Ship s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyTo'");
    }

    @Override
    public void update() {
        forward.x = YASC.sin(rot);
        forward.y = -YASC.sin(rot);
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
}
