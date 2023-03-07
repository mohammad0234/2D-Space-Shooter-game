package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView  {

    private Image background;
    private SpaceShooter mainShooter;

   // private static Image background = new ImageIcon("data/backgroundSpace_01.1.png").getImage();
    public GameView(World w, SpaceShooter shooter, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/backgroundSpace_01.1.png").getImage();

        mainShooter = shooter;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(background, 0, 0, this);

    }

    protected void paintForeground(Graphics2D g){
        g.drawString("Total score: " + mainShooter.getTotalScore(), 20, 60);
    }
}
