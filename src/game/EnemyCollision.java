package game;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.security.PrivateKey;

public class EnemyCollision implements CollisionListener, ActionListener{

    private SpaceShooter mainShooter;
    private Body otherBody;

    public EnemyCollision(SpaceShooter s){
        mainShooter = s;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        collisionEvent.getReportingBody().destroy();
        if (collisionEvent.getOtherBody() instanceof Enemy || collisionEvent.getOtherBody() instanceof Asteroids)  {
            otherBody = collisionEvent.getOtherBody();
            mainShooter.setTotalScore(mainShooter.getTotalScore()+5);
            final BodyImage explosionGif = new BodyImage("data/ezgif.gif", 3);
            collisionEvent.getOtherBody().addImage(explosionGif);

            Timer timer = new Timer(500, this );
            timer.setRepeats(false);
            timer.start();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        otherBody.destroy();

    }
}
