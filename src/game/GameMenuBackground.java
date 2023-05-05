package game;

import javax.swing.*;
import java.awt.*;

public class GameMenuBackground extends JPanel {

    private Image endBackground;

    public GameMenuBackground(){
        endBackground = new ImageIcon("data/Background/EndBack.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(endBackground,0,0,800,600,null);
    }
}
