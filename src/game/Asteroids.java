package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Asteroids extends Walker implements StepListener {

    private float left,right;

    private float deltaX;

    private static final Shape asteroidShape = new PolygonShape(-0.072f,0.498f, -0.43f,0.224f, -0.486f,-0.35f, -0.288f,-0.494f,
            0.092f,-0.49f, 0.492f,-0.142f, 0.304f,0.426f);

    private static final BodyImage image = new BodyImage("data/Asteroids/asteroid03.png", 1f);

    public Asteroids(World world) {
        super(world,asteroidShape);
        addImage(image);
        world.addStepListener(this);
        startWalking(5);
    }

    public void setPosition(Vec2 position){
        super.setPosition((position));
        left = position.x-12;
        right = position.x+12;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x>right){
            startWalking(-5);
            deltaX*=-1;
        }

        if (getPosition().x<left){
            startWalking(5);
            deltaX*=-1;
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
