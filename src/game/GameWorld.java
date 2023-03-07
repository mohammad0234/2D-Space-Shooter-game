package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class GameWorld extends World {
    SpaceShooter mainShooter;

    public GameWorld() {
        //2. populate gameworld with bodies (ex: platforms, collectibles, characters)

        Color transparentBlack = new Color(0, 0, 0, 0);

        //make a ground platform
        Shape shape = new BoxShape(30, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));
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


        // make a suspended platform
        //Shape platformShape = new BoxShape(3, 0.5f);
        // StaticBody platform1 = new StaticBody(this, platformShape);
        //platform1.setPosition(new Vec2(-8, -4f));

        //make a character (with an overlaid image)

        mainShooter = new SpaceShooter(this);
        mainShooter.setPosition(new Vec2(0, -12));

        Enemy enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-2, 10));
        enemy1.setGravityScale(0);

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-1, 10));
        enemy2.setGravityScale(0);

        Asteroids asteroid1 = new Asteroids(this);
        asteroid1.setPosition(new Vec2(-2,10));
        asteroid1.setGravityScale(0);
    }

    public SpaceShooter getShooter(){
        return mainShooter;
    }

}
