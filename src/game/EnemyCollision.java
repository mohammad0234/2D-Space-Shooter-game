package game;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;


public class EnemyCollision implements CollisionListener, ActionListener{

    private static SoundClip explosionSound;

    static {
        try {
            explosionSound = new SoundClip("data/Sound/ExplodeSound.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private SpaceShooter mainShooter;

    private Body otherBody;

    public EnemyCollision(SpaceShooter shoot){
        mainShooter = shoot;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Enemy ||  collisionEvent.getOtherBody() instanceof EnemyLvl2
                || collisionEvent.getOtherBody() instanceof Asteroids
                || collisionEvent.getOtherBody() instanceof SpaceShooter)  {
            collisionEvent.getReportingBody().destroy();
            otherBody = collisionEvent.getOtherBody();
            mainShooter.addPoints();
            final BodyImage explosionGif = new BodyImage("data/ezgif.gif", 3);
            collisionEvent.getOtherBody().addImage(explosionGif);//adds animation when body is destroyed
            explosionSound.play();

            Timer timer = new Timer(500, this );
            timer.setRepeats(false);
            timer.start();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {   //Bullet destroys enemy with animation
        otherBody.destroy();
    }
}
