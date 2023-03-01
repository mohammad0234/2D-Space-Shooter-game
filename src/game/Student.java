package game;


import city.cs.engine.*;

public class Student extends DynamicBody {
    private static final Shape studentShape = new BoxShape(1,2);

    private static final BodyImage image = new BodyImage("data/ship.png", 4);

    public Student(World world){
        super(world,studentShape);
        this.addImage(image);
    }
}
