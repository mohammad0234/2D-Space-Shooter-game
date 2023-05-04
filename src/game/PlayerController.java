package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class PlayerController implements KeyListener {

    private static SoundClip laserSound;

    static {
        try {
            laserSound = new SoundClip("data/Sound/Shooting.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
        }
    }

    SpaceShooter mainShooter;
    Enemy shooting;

    public PlayerController (SpaceShooter mainShooter){
        this.mainShooter = mainShooter;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        // other key commands omitted
        if ((code == KeyEvent.VK_LEFT ) || (code == KeyEvent.VK_A )) {
            mainShooter.startWalking(-11);
        }

        else if ((code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_D)) {
            mainShooter.startWalking(11);
        }

        else if (code == KeyEvent.VK_SPACE) {
            mainShooter.shoot();
            laserSound.play();
        }

        else if (code == KeyEvent.VK_P) {
            shooting.enemyShoot();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if ((code == KeyEvent.VK_LEFT ) || (code == KeyEvent.VK_A)) {
            mainShooter.stopWalking();
        }

        else if ((code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_D)) {
            mainShooter.stopWalking();
        }
    }

    public void updateShooter (SpaceShooter newShooter){
        mainShooter = newShooter;
    }
}
