package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyTimerCode3 extends World implements ActionListener {
    private GameLevel gl;

    int x;

    Random random;

    public MyTimerCode3(GameLevel gl){
        this.gl = gl;
    }

    int counter = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println(counter);

        EnemyLvl3 er1 = new EnemyLvl3(gl);
        er1.setPosition(new Vec2(-9f, 7.5f));
        er1.setGravityScale(0);
        er1.setValue();

        EnemyLvl3 er2 = new EnemyLvl3(gl);
        er2.setPosition(new Vec2(-3, 10.5f));
        er2.setGravityScale(0);
        er2.setValue();

        EnemyLvl2 er3 = new EnemyLvl2(gl);
        er3.setPosition(new Vec2(3, 7.5f));
        er3.setGravityScale(0);
        er3.setValue();

        Asteroids as1 = new Asteroids(gl);
        random = new Random();
        x = random.nextInt(20)-10;
        as1.setPosition(new Vec2(x, 15f) );
        as1.setGravityScale(0);
        as1.setValue();

        Asteroids as2 = new Asteroids(gl);
        random = new Random();
        x = random.nextInt(20)-10;
        as2.setPosition(new Vec2(x, 15f) );
        as2.setGravityScale(0);
        as2.setValue();

        Asteroids as3 = new Asteroids(gl);
        random = new Random();
        x = random.nextInt(20)-10;
        as3.setPosition(new Vec2(x, 15f) );
        as3.setGravityScale(0);
        as3.setValue();

    }

}
