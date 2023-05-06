package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AsteroidCollision implements CollisionListener, ActionListener {

    private static SoundClip explosionSound;

    static {
        try {
            explosionSound = new SoundClip("data/Sound/ExplodeSound.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e); //sounds for explosion sound once collided
        }
    }
    private Body otherBody;
    private Shape shape;
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof SpaceShooter || collisionEvent.getOtherBody() instanceof Enemy
                || collisionEvent.getOtherBody() instanceof EnemyLvl2 //When asteroid collides with all these bodies then it destroys them
                || collisionEvent.getOtherBody() instanceof EnemyLvl3){
            collisionEvent.getReportingBody().destroy();
            otherBody = collisionEvent.getOtherBody();

            final BodyImage explosionGif = new BodyImage("data/ezgif.gif", 3);
            collisionEvent.getOtherBody().addImage(explosionGif);  //adds animation when body is destroyed
            explosionSound.play();

            Timer timer = new Timer(500, this ); //Timer for how long the explosion lasts.
            timer.setRepeats(true);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        otherBody.destroy();
    }
}
