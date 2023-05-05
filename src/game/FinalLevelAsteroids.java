package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class FinalLevelAsteroids  extends Walker implements StepListener {

    private float left,right;

    private float deltaY = -0.05f; //how slow it moves down

    Vec2 startPosition;

    float xPos;

    private static final Shape asteroidShape = new PolygonShape(1.123f,0.88f, -0.971f,0.916f, -0.956f,
            -0.87f, 1.16f,-0.833f, 1.154f,0.869f);

    private static final BodyImage image = new BodyImage("data/Asteroids/asteroidLvl3.png", 1f);

    public FinalLevelAsteroids(World world) {
        super(world,asteroidShape);
        addImage(image);
        world.addStepListener(this);
        startWalking(1);
        FinalAsteroidCollision ac = new FinalAsteroidCollision();
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
