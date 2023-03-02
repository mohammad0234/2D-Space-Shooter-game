package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView  {

    private static Image background = new ImageIcon("data/backgroundSpace_01.1.png").getImage();
    public GameView(GameWorld w, int width, int height) {
        super(w, width, height);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(background, 0, 0, this);

    }
}
