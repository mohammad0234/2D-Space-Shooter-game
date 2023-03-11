package game;

import city.cs.engine.SoundClip;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

    SpaceShooter mainShooter;

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
        if ((code == KeyEvent.VK_LEFT ) || (code == KeyEvent.VK_A)) {
            mainShooter.startWalking(-11);
        }

        else if ((code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_D)) {
            mainShooter.startWalking(11);
        }

        else if (code == KeyEvent.VK_SPACE) {
            mainShooter.shoot();
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
}
