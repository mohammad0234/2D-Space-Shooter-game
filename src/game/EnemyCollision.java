package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import java.security.PrivateKey;

public class EnemyCollision implements CollisionListener {

    private SpaceShooter mainShooter;


    public EnemyCollision(SpaceShooter s){
        mainShooter = s;
    }


    @Override
    public void collide(CollisionEvent collisionEvent) {
        collisionEvent.getReportingBody().destroy();
        if (collisionEvent.getOtherBody() instanceof Enemy || collisionEvent.getOtherBody() instanceof Asteroids)  {
            collisionEvent.getOtherBody().destroy();
            mainShooter.setTotalScore(mainShooter.getTotalScore()+5);
        }

    }
}
