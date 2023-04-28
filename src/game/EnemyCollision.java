package game;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class EnemyCollision implements CollisionListener, ActionListener{

//    GameLevel level;
//    Game g;

//    public EnemyCollision (GameLevel level){
//        this.level=level;
//    }

    private SpaceShooter mainShooter;
    private Body otherBody;

    public EnemyCollision(SpaceShooter shoot){
        mainShooter = shoot;
//        this.level=level;
//        g = game;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Enemy || collisionEvent.getOtherBody() instanceof Asteroids)  {
            collisionEvent.getReportingBody().destroy();
            otherBody = collisionEvent.getOtherBody();
            mainShooter.addPoints();
            final BodyImage explosionGif = new BodyImage("data/ezgif.gif", 3);
            collisionEvent.getOtherBody().addImage(explosionGif);  //adds animation when body is destroyed

            Timer timer = new Timer(500, this );
            timer.setRepeats(false);
            timer.start();

//            if (level.isComplete){
//                g.goToNextLevel();
//            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {   //Bullet destroys enemy with animation
        otherBody.destroy();
    }
}
