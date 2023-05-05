package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Level3 extends GameLevel{
    public SoundClip gameMusic;

    private Timer timer;

    public Level3(Game game){
        super(game);

        EnemyLvl3 enemy1 = new EnemyLvl3(this);
        enemy1.setPosition(new Vec2(-2.5f, 4.5f));
        enemy1.setGravityScale(0);
        enemy1.setValue();

        EnemyLvl3 enemy2 = new EnemyLvl3(this);
        enemy2.setPosition(new Vec2(3f, 4.5f));
        enemy2.setGravityScale(0);
        enemy2.setValue();

        EnemyLvl3 enemy3 = new EnemyLvl3(this);
        enemy3.setPosition(new Vec2(-6f, 7.5f));
        enemy3.setGravityScale(0);
        enemy3.setValue();

        EnemyLvl3 enemy4 = new EnemyLvl3(this);
        enemy4.setPosition(new Vec2(0, 7.5f));
        enemy4.setGravityScale(0);
        enemy4.setValue();

        EnemyLvl3 enemy5 = new EnemyLvl3(this);
        enemy5.setPosition(new Vec2(-3f, 10.5f));
        enemy5.setGravityScale(0);
        enemy5.setValue();

        EnemyLvl3 enemy6 = new EnemyLvl3(this);
        enemy6.setPosition(new Vec2(3f, 10.5f));
        enemy6.setGravityScale(0);
        enemy6.setValue();

        MyTimerCode3 timerResponse = new MyTimerCode3(this);  //Enemy respawn timer
        timer = new Timer(3000, timerResponse);
        timer.setInitialDelay(5000);
        timer.start();


//        Asteroids asteroid1 = new Asteroids(this);
//        asteroid1.setPosition(new Vec2(0,4.5f));
//        asteroid1.setGravityScale(0);
//        asteroid1.setValue();
//
//        Asteroids asteroid2 = new Asteroids(this);
//        asteroid2.setPosition(new Vec2(-6f,4.5f));
//        asteroid2.setGravityScale(0);
//        asteroid2.setValue();
//
//        Asteroids asteroid3 = new Asteroids(this);
//        asteroid3.setPosition(new Vec2(-3f,7.5f));
//        asteroid3.setGravityScale(0);
//        asteroid3.setValue();
//
//        Asteroids asteroid4 = new Asteroids(this);
//        asteroid4.setPosition(new Vec2(3f,7.5f));
//        asteroid4.setGravityScale(0);
//        asteroid4.setValue();
//
//        Asteroids asteroid5 = new Asteroids(this);
//        asteroid5.setPosition(new Vec2(-6f,10.5f));
//        asteroid5.setGravityScale(0);
//        asteroid5.setValue();
//
//        Asteroids asteroid6 = new Asteroids(this);
//        asteroid6.setPosition(new Vec2(0,10.5f));
//        asteroid6.setGravityScale(0);
//        asteroid6.setValue();

        try {
            gameMusic = new SoundClip("data/Sound/music/level3.mid");
            gameMusic.loop();

        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean isComplete() {
        return getShooter().getTotalScore()>1000;
    }
}
