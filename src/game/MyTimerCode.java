package game;


import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyTimerCode extends World implements ActionListener {

    private GameLevel gl;

    int x;

    public MyTimerCode(GameLevel gl){
        this.gl = gl;
//        x = ThreadLocalRandom.current().nextInt(-15,15);
//        setPosition(new Vec2(x, -12));
    }

    private void setPosition(Vec2 vec2) {

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
        Random random = new Random();
        int x = random.nextInt(20)-10;
        as1.setPosition(new Vec2(x, 10.5f));
        as1.setGravityScale(0);
        as1.setValue();


    }

}

