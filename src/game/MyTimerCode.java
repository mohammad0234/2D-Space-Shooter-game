package game;


import city.cs.engine.World;
import org.jbox2d.common.Vec2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyTimerCode extends World implements ActionListener {

    private GameLevel gl;

    int x;

    Random random;

    public MyTimerCode(GameLevel gl){
        this.gl = gl;
    }

    Asteroids as1,as2;

    @Override
    public void actionPerformed(ActionEvent e) {
        //counter++;

        Enemy er1 = new Enemy(gl);
        er1.setPosition(new Vec2(-9f, 7.5f));
        er1.setGravityScale(0);
        er1.setValue();

        Enemy er2 = new Enemy(gl);
        er2.setPosition(new Vec2(-3, 10.5f));
        er2.setGravityScale(0);
        er2.setValue();

        Enemy er3 = new Enemy(gl);
        er3.setPosition(new Vec2(3, 7.5f));
        er3.setGravityScale(0);
        er3.setValue();

        as1 = new Asteroids(gl);
        random = new Random();
        x = random.nextInt(20)-10;
        as1.setPosition(new Vec2(x, 15f) );
        as1.setGravityScale(0);
        as1.setValue();

        as2 = new Asteroids(gl);
        random = new Random();
        x = random.nextInt(20)-10;
        as2.setPosition(new Vec2(x, 15f) );
        as2.setGravityScale(0);
        as2.setValue();

    }

}

