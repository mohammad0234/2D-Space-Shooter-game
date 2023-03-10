package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class GameWorld extends World  {
    static SpaceShooter mainShooter;
    int numWidthEnemy = 11;
    int numHeightEnemy = 5;
    int enemySpacing = 40;

    public GameWorld() {
        //2. populate gameworld with bodies (ex: platforms, collectibles, characters)

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

        //make a character (with an overlaid image)

        mainShooter = new SpaceShooter(this);
        mainShooter.setPosition(new Vec2(0, -12));

        Star star = new Star(this);

        Enemy enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-2.5f, 4.5f));
        enemy1.setGravityScale(0);
        enemy1.setValue();

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(3f, 4.5f));
        enemy2.setGravityScale(0);
        enemy2.setValue();

        Enemy enemy3 = new Enemy(this);
        enemy3.setPosition(new Vec2(-6f, 7.5f));
        enemy3.setGravityScale(0);
        enemy3.setValue();

        Enemy enemy4 = new Enemy(this);
        enemy4.setPosition(new Vec2(0, 7.5f));
        enemy4.setGravityScale(0);
        enemy4.setValue();

        Enemy enemy5 = new Enemy(this);
        enemy5.setPosition(new Vec2(-3f, 10.5f));
        enemy5.setGravityScale(0);
        enemy5.setValue();

        Enemy enemy6 = new Enemy(this);
        enemy6.setPosition(new Vec2(3f, 10.5f));
        enemy6.setGravityScale(0);
        enemy6.setValue();


        Asteroids asteroid1 = new Asteroids(this);
        asteroid1.setPosition(new Vec2(0,4.5f));
        asteroid1.setGravityScale(0);
        asteroid1.setValue();

        Asteroids asteroid2 = new Asteroids(this);
        asteroid2.setPosition(new Vec2(-6f,4.5f));
        asteroid2.setGravityScale(0);
        asteroid2.setValue();

        Asteroids asteroid3 = new Asteroids(this);
        asteroid3.setPosition(new Vec2(-3f,7.5f));
        asteroid3.setGravityScale(0);
        asteroid3.setValue();

        Asteroids asteroid4 = new Asteroids(this);
        asteroid4.setPosition(new Vec2(3f,7.5f));
        asteroid4.setGravityScale(0);
        asteroid4.setValue();

        Asteroids asteroid5 = new Asteroids(this);
        asteroid5.setPosition(new Vec2(-6f,10.5f));
        asteroid5.setGravityScale(0);
        asteroid5.setValue();

        Asteroids asteroid6 = new Asteroids(this);
        asteroid6.setPosition(new Vec2(0,10.5f));
        asteroid6.setGravityScale(0);
        asteroid6.setValue();

        Pickup g = new Pickup(mainShooter,this);
        //star.addCollisionListener(g);
        mainShooter.addCollisionListener(g);


    }

    public static SpaceShooter getShooter(){
        return mainShooter;
    }

}
