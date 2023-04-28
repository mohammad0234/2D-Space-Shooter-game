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

    /** Initialise a new Game. */
    public Game() {


        //1. make an empty game world
       // World world = new World();

        Level1 world = new Level1();

        //3. make a view to look into the game world
        GameView view = new GameView(world, world.getShooter(), 800, 600);
        view.setZoom(20);

        PlayerController sc = new PlayerController(world.getShooter());
        view.addKeyListener(sc);

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
        world.start();

    }

//      public void goToNextLevel(){
//          System.out.println("Next level");
////        if (level instanceof Level1){
////            level.stop();
////            level = new Level2(this);
////            //level now refer to the new level
////            view.setWorld(level);
////            controller.updateStudent(level.getStudent());
////            level.start();
////        }
////        else if (level instanceof Level2){
////            System.out.println("Well done! Game complete.");
////            System.exit(0);
////        }
//    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
