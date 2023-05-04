package game;


import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimerCode extends World implements ActionListener {

    private GameLevel gl;

    //private Timer timer;

    //private int tCounter = 0;
    public MyTimerCode(GameLevel gl){
        this.gl = gl;
    }
    int counter = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println(counter);
        //tCounter++;

        Enemy er1 = new Enemy(gl);
        er1.setPosition(new Vec2(-6f, 7.5f));
        er1.setGravityScale(0);
        er1.setValue();

        Enemy er2 = new Enemy(gl);
        er2.setPosition(new Vec2(0, 7.5f));
        er2.setGravityScale(0);
        er2.setValue();

        Asteroids as1 = new Asteroids(gl);
        as1.setPosition(new Vec2(-3f, 10.5f));
        as1.setGravityScale(0);
        as1.setValue();


//        if (tCounter == 1){
//            timer.setDelay(500);
//        }
//
//        if (tCounter==3){
//            timer.setDelay(5000);
//            tCounter = 0;
//        }
    }

}

