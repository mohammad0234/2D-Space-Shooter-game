package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.concurrent.ThreadLocalRandom;

public class Asteroids extends Walker implements StepListener {

    private float left,right;

    private float deltaY = -0.05f; //how slow it moves down

    Vec2 startPosition;

    float xPos;

    private static final Shape asteroidShape = new PolygonShape(-0.072f,0.498f, -0.43f,0.224f, -0.486f,-0.35f, -0.288f,-0.494f,
            0.092f,-0.49f, 0.492f,-0.142f, 0.304f,0.426f);

    private static final BodyImage image = new BodyImage("data/Asteroids/asteroid03.png", 1f);

    public Asteroids(World world) {
        super(world,asteroidShape);
        addImage(image);
        world.addStepListener(this);
        startWalking(1);
        AsteroidCollision ac = new AsteroidCollision();
        addCollisionListener(ac);
    }

    public void setValue(){
        startPosition = this.getPosition();
        left = startPosition.x-12;
        right = startPosition.x+12;
    }

    @Override
    public void preStep(StepEvent stepEvent) {  // moves asteroids right to left
        if (getPosition().x>right){
            startWalking(-2);
        }

        if (getPosition().x<left){
            startWalking(2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              );
        }

       this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+ deltaY));  // moves asteroids down
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
