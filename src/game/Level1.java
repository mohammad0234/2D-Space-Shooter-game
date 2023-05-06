package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Level1 extends GameLevel {
    public SoundClip gameMusic;

    private Timer timer;

    public Level1(Game game){

        super(game);

        Enemy enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-6f, 7.5f));
        enemy1.setGravityScale(0);
        enemy1.setValue();

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(0f, 7.5f));
        enemy2.setGravityScale(0);
        enemy2.setValue();

        Enemy enemy3 = new Enemy(this);
        enemy3.setPosition(new Vec2(6f, 7.5f));
        enemy3.setGravityScale(0);
        enemy3.setValue();

        MyTimerCode timerResponse = new MyTimerCode(this);  //Enemy respawn timer
        timer = new Timer(5200, timerResponse);
        timer.setInitialDelay(6000);
        timer.start();

        try {
            gameMusic = new SoundClip("data/Sound/music/level1.wav");  //Background music for level 1
            gameMusic.loop();

        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
        }
    }

    @Override
    public boolean isComplete() {
        return getShooter().getStarCount()>=2;
    }
}
