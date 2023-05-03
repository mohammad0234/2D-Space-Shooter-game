package game;


import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import java.io.IOException;

/**
 * Your main game entry point
 */
public class Game {
    GameLevel currentLevel;

    GameView view;
    PlayerController controller;

    /** Initialise a new Game. */
    public Game() {


        //1. make an empty game world
       // World world = new World();

        currentLevel = new Level1(this);

        //3. make a view to look into the game world
        view = new GameView(currentLevel, currentLevel.getShooter(), 800, 600);
        view.setZoom(20);

        controller = new PlayerController(currentLevel.getShooter());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("Space Shooter Game");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        currentLevel.start();

    }

      public void goToNextLevel(){
        if (currentLevel instanceof Level1){
            ((Level1) currentLevel).gameMusic.stop();

            SpaceShooter prevShooter = currentLevel.getShooter();

            currentLevel = new Level2(this);
            SpaceShooter newShooter = currentLevel.getShooter();

            //level now refer to the new level
            view.setWorld(currentLevel);
            controller.updateShooter(currentLevel.getShooter());
            currentLevel.start();
        }
        else if (currentLevel instanceof Level2){
            ((Level2) currentLevel).gameMusic.stop();
            SpaceShooter prevShooter = currentLevel.getShooter();

            currentLevel = new Level3(this);
            SpaceShooter newShooter = currentLevel.getShooter();

            //level now refer to the new level
            view.setWorld(currentLevel);
            controller.updateShooter(currentLevel.getShooter());
            currentLevel.start();
        }
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
