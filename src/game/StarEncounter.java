package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class StarEncounter implements CollisionListener {
    private GameLevel level;
    private Game g;

    public StarEncounter(GameLevel level, Game game){
        this.level = level;
        g = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (level.isComplete()){
            g.goToNextLevel();
        }
    }
}
