package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    public GameWorld(){
        //2. populate gameworld with bodies (ex: platforms, collectibles, characters)

        //make a ground platform
        Shape shape = new BoxShape(30, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -12.3f));



        // make a suspended platform
        //Shape platformShape = new BoxShape(3, 0.5f);
       // StaticBody platform1 = new StaticBody(this, platformShape);
        //platform1.setPosition(new Vec2(-8, -4f));

        //make a character (with an overlaid image)

        Student student = new Student(this);
        student.setPosition(new Vec2(7,-9));
    }
}
