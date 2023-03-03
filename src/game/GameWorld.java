package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class GameWorld extends World {
    public GameWorld() {
        //2. populate gameworld with bodies (ex: platforms, collectibles, characters)

        //make a ground platform
        Shape shape = new BoxShape(30, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -14.9f));
        ground.setFillColor(Color.BLACK);


        // make a suspended platform
        //Shape platformShape = new BoxShape(3, 0.5f);
        // StaticBody platform1 = new StaticBody(this, platformShape);
        //platform1.setPosition(new Vec2(-8, -4f));

        //make a character (with an overlaid image)

        SpaceShooter shooter = new SpaceShooter(this);
        shooter.setPosition(new Vec2(0, -12));



        Enemy enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-2, 10));
        enemy1.setGravityScale(0);

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-1, 10));
        enemy2.setGravityScale(0);
    }
}
