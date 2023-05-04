package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsteroidCollision implements CollisionListener, ActionListener {

    private Body otherBody;
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof SpaceShooter || collisionEvent.getOtherBody() instanceof Enemy){
            collisionEvent.getReportingBody().destroy();
            otherBody = collisionEvent.getOtherBody();

            final BodyImage explosionGif = new BodyImage("data/ezgif.gif", 3);
            collisionEvent.getOtherBody().addImage(explosionGif);  //adds animation when body is destroyed

            Timer timer = new Timer(500, this );
            timer.setRepeats(true);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        otherBody.destroy();
    }
}
