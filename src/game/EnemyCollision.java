package game;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

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
            //collisionEvent.getOtherBody().destroy();
            mainShooter.setTotalScore(mainShooter.getTotalScore()+5);
            final BodyImage explosionGif = new BodyImage("data/ezgif3.gif", 3);

            collisionEvent.getOtherBody().addImage(explosionGif);

            /*Timer timer = new Timer(1000, );
            timer.setInitialDelay(100);
            timer.start();*/
        }


    }
}
