package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EnemyLvl2 extends Walker implements StepListener {

    private float left,right;

    private float deltaY = -0.007f;  // how slow it moves down

    Vec2 startPosition;

    private static final Shape enemy2Shape = new PolygonShape(-0.004f,0.936f, -0.94f,0.336f, -0.96f,-0.06f, -0.024f,
            -0.996f, 0.96f,-0.18f, 0.936f,0.332f, 0.04f,0.928f);

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
            startWalking(-8);
        }

        if (getPosition().x<left){
            startWalking(8);
        }

        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+ deltaY));  //enemies move down towards player

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
