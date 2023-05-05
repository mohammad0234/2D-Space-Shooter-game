package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class SpaceShooter extends Walker {
    private static final Shape spaceShape = new PolygonShape(1.36f,-0.79f, 1.36f,-0.6f, 0.32f,1.48f, -0.28f,1.48f,
            -1.36f,-0.56f, -1.36f,-0.79f);

    private static final BodyImage image = new BodyImage("data/Player/ship.png", 3);
    private int starCount;
    int totalScore, points ;

    //private static SoundClip shootingSound;

    public SpaceShooter(World world){
        super(world,spaceShape);
        SolidFixture t = new SolidFixture(this,spaceShape);
        t.setFriction(20); // spaceshooter stops moving once key is released
        this.addImage(image);
        points = 5;
        totalScore = 0;
    }

    public void shoot(){
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        projectile.setFillColor(Color.red);
        projectile.addImage(new BodyImage("data/Projectiles/fire01.png", 0.9f));

        EnemyCollision impact = new EnemyCollision(this);
        projectile.addCollisionListener(impact);
        projectile.setGravityScale(0);

        projectile.setPosition(new Vec2(this.getPosition().x,this.getPosition().y+2));
        projectile.setLinearVelocity(new Vec2(0,40));

    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addPoints(){
        totalScore+=points;
    }

    public void multiplyPoints(){
        points=points*2;  // used in Pickup class
    }

}
