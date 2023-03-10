package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

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
            mainShooter.multiplyPoints();

            Timer timer = new Timer(20000,this);
            timer.setRepeats(true);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Star(world);
    }
}
