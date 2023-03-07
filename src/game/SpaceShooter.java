package game;


import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class SpaceShooter extends Walker {
    private static final Shape spaceShape = new BoxShape(1,2);

    private static final BodyImage image = new BodyImage("data/Player/ship.png", 3);

    private int credits;

    int totalScore;

    public SpaceShooter(World world){
        super(world,spaceShape);
        this.addImage(image);

        totalScore = 0;
    }

    public void shoot(){
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));

        EnemyCollision impact = new EnemyCollision(this);
        projectile.addCollisionListener(impact);
        projectile.setGravityScale(0);

        projectile.setPosition(new Vec2(this.getPosition().x+2,
                this.getPosition().y));
        projectile.setLinearVelocity(new Vec2(0,40));
       // projectile.setGravityScale(0);

    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
        System.out.println(totalScore);
    }
}
