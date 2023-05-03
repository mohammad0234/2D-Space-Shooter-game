package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pickup implements CollisionListener, ActionListener {

    private SpaceShooter mainShooter;
    World world;

    public Pickup(SpaceShooter mainShooter, World w) {
        this.mainShooter = mainShooter;
        this.world = w;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Star){
            e.getOtherBody().destroy();
            mainShooter.multiplyPoints();  // if star is picked up, points are multiplied
            mainShooter.setStarCount(mainShooter.getStarCount()+1);

            Timer timer = new Timer(2000,this);
            timer.setRepeats(true);
            timer.start();
            timer.isRunning();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Star(world);    //new star is spawned in after a set amount of time.
    }

}
