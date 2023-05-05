package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EnemyLvl2 extends Walker implements StepListener {

    private float left,right;

    private float deltaY = -0.005f;  // how slow it moves down

    Vec2 startPosition;

    private static final Shape enemy2Shape = new PolygonShape(0.01f,1.39f, -1.45f,0.55f, -1.4f,-0.56f, -0.37f,
            -1.5f, 0.71f,-1.48f, 1.48f,0.1f, 0.05f,1.39f);

    private static final BodyImage image = new BodyImage("data/Enemies/enemyHeavy.png", 3);

    public EnemyLvl2(World world) {
        super(world,enemy2Shape);
        addImage(image);
        world.addStepListener(this);
        startWalking(5);
    }

    public void setValue(){
        startPosition = this.getPosition();
        left = startPosition.x-8f;
        right = startPosition.x+8f;
    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x>right){
            startWalking(-7);
        }

        if (getPosition().x<left){
            startWalking(7);
        }

        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+ deltaY));  //enemies move down towards player

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
