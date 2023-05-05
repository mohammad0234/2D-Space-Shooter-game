package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EnemyLvl3 extends Walker implements StepListener {
    private float left,right;

    private float deltaY = -0.005f;  // how slow it moves down

    Vec2 startPosition;

    private static final Shape enemy3Shape = new PolygonShape(-0.116f,0.984f, -0.64f,-0.004f, -0.32f,-0.984f,
            0.356f,-0.972f, 0.648f,0.012f, 0.104f,0.996f);

    private static final BodyImage image = new BodyImage("data/Enemies/Spaceship.png", 3);

    public EnemyLvl3(World world) {
        super(world,enemy3Shape);
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
