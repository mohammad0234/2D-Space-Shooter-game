package game;


import city.cs.engine.*;

public class SpaceShooter extends DynamicBody {
    private static final Shape spaceShape = new BoxShape(1,2);

    private static final BodyImage image = new BodyImage("data/Player/ship.png", 3);

    public SpaceShooter(World world){
        super(world,spaceShape);
        this.addImage(image);
    }
}
