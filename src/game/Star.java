package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Star extends Walker {

    Random star;  // Random variable
    float xPos;

    private static final Shape starShape = new PolygonShape(0.028f,0.976f, 0.9f,0.636f, 0.924f,-0.544f, 0.184f,
            -0.988f, -0.664f,-0.82f, -0.984f,0.116f, -0.556f,1.048f);

    private static final BodyImage image = new BodyImage("data/starPickup.png", 1.5f);
    public Star(World world) {
        super(world,starShape);
        addImage(image);
        xPos= ThreadLocalRandom.current().nextInt(-15, 15);
        setPosition(new Vec2(xPos, -12));  //randomised drop of stars on the x coordinate
    }

}
