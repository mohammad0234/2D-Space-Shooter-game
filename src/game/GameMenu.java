package game;

import javax.swing.*;

public class GameMenu {
    private JButton quitButton;
    private JButton restartButton;
    private JPanel mainPanel;

    public JPanel getMainPanel(){
        return mainPanel;
    }

    private void createUIComponents() {
        mainPanel = new GameMenuBackground();
    }
}
