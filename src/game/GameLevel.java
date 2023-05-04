package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import javax.swing.*;

import java.awt.*;

public abstract class GameLevel extends World {

    private SpaceShooter mainShooter;

    private Game game;

    private Timer timer;

    public GameLevel(Game game){

        this.game = game;

        Color transparentBlack = new Color(0, 0, 0, 0);

        //make a ground platform
        Shape shape = new BoxShape(30, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -14f));
        ground.setFillColor(transparentBlack);
        ground.setLineColor(transparentBlack);

        Shape shape2 = new BoxShape(0.1f, 20f);
        StaticBody leftSide = new StaticBody(this, shape2);
        leftSide.setPosition(new Vec2(-19.7f, 2f));
        leftSide.setFillColor(transparentBlack);
        leftSide.setLineColor(transparentBlack);

        Shape shape3 = new BoxShape(0.1f, 20f);
        StaticBody rightSide = new StaticBody(this, shape3);
        rightSide.setPosition(new Vec2(19.7f, 2f));
        rightSide.setFillColor(transparentBlack);
        rightSide.setLineColor(transparentBlack);

        mainShooter = new SpaceShooter(this);
        mainShooter.setPosition(new Vec2(0, -12));

        Star star = new Star(this);

        Pickup pick = new Pickup(mainShooter,this);
        mainShooter.addCollisionListener(pick);  // calls on the pickup method to repsawn in again and so the collision works when it respawns

        mainShooter.addCollisionListener(new StarEncounter(this,game));

        MyTimerCode timerResponse = new MyTimerCode(this);  //Enemy respawn timer
        timer = new Timer(3000, timerResponse);
        timer.setInitialDelay(5000);
        timer.start();

    }

    public SpaceShooter getShooter(){
        return mainShooter;
    }
    public abstract boolean isComplete();
}
