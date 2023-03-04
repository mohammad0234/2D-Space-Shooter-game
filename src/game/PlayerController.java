package game;

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
        System.out.println("Key pressed "+ e.getKeyChar());

        int code = e.getKeyCode();
        // other key commands omitted
        if ((code == KeyEvent.VK_LEFT ) || (code == KeyEvent.VK_A)) {
            mainShooter.startWalking(-10);
        }

        else if ((code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_D)) {
            mainShooter.startWalking(10);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            mainShooter.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            mainShooter.stopWalking();
        }
    }
}
