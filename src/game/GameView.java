package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView  {

    private Image background;
    private SpaceShooter mainShooter;
    private GameLevel currentLevel;


    public GameView(GameLevel w, SpaceShooter shooter, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/Background/bg1.png").getImage();

        mainShooter = shooter;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(background, 0, 0, this);

    }
    @Override
    protected void paintForeground(Graphics2D g){
        g.setColor(Color.white);
        g.drawString("Total score: " + mainShooter.getTotalScore(), 10, 30);  // calls on my total score and sets position
        g.drawString("Star picked: " + mainShooter.getStarCount(), 10,50);
    }

    public void setWorld(GameLevel gl){
        super.setWorld(gl);
        this.currentLevel = gl;
        this.mainShooter = currentLevel.getShooter();

        if (currentLevel instanceof Level1){
            background = new ImageIcon("data/backgroundSpace_01.1.png").getImage();
        }
        else if
        (currentLevel instanceof Level2){
            background = new ImageIcon("data/Background/bg2.jpg").getImage();
        }
        else if(currentLevel instanceof Level3){
            background = new ImageIcon("data/Background/bg3.png").getImage();
        }
    }
}
