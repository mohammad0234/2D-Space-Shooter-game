package game;

import city.cs.engine.*;

public class Enemy extends Walker {

   private static final Shape enemyShape = new BoxShape(3,4);

    private static final BodyImage image = new BodyImage("data/Enemies/enemyNimble.png", 3);

    public Enemy(World world) {
        super(world,enemyShape);
        addImage(image);
    }
}

