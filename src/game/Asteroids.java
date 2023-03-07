package game;

import city.cs.engine.*;

public class Asteroids extends Walker {

    private static final Shape asteroidShape = new BoxShape(3,4);

    private static final BodyImage image = new BodyImage("data/Asteroids/asteroid01.png", 1);

    public Asteroids(World world) {
        super(world,asteroidShape);
        addImage(image);
    }
}
