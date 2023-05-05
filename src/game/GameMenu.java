package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu {
    private JButton quitButton;
    private JButton restartButton;
    private JPanel mainPanel;

    public GameMenu(Game game) {
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart level");
                game.restartGame();
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    private void createUIComponents() {
        mainPanel = new GameMenuBackground();
    }
}
