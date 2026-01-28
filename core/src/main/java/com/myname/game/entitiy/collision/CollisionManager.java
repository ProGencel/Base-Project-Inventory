package com.myname.game.entitiy.collision;


import com.badlogic.gdx.utils.Array;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Colladable;

public class CollisionManager {

    public static boolean isWillCollision(Colladable colladableEntity, Array<GameEntity> obstacles)
    {
        for(GameEntity gameEntity : obstacles)
        {
            if(colladableEntity.getFutureRectangle().overlaps(gameEntity.getRectangle()))
            {
                return true;
            }
        }
        return false;
    }

}
