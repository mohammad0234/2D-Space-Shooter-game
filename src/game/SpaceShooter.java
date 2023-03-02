package game;


import city.cs.engine.*;

public class SpaceShooter extends DynamicBody {
    private static final Shape studentShape = new BoxShape(1,2);

    private static final BodyImage image = new BodyImage("data/ship.png", 3);

    public SpaceShooter(World world){
        super(world,studentShape);
        this.addImage(image);
    }
}
