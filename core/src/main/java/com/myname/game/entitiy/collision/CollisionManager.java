package com.myname.game.entitiy.collision;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.entitiy.staticEntity.StaticEntity;
import com.myname.game.interfaces.Colladable;

public class CollisionManager {

    public static boolean isWillCollision(Rectangle bounds, Array<GameEntity> obstacles)
    {
        for(GameEntity gameEntity : obstacles)
        {
            if(bounds.overlaps(gameEntity.getRectangle()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isWillCollisionSensor(Rectangle bounds, Array<GameEntity> obstacles)
    {
        for(GameEntity gameEntity : obstacles)
        {

            StaticEntity staticEntity = (StaticEntity) gameEntity;

            if(bounds.overlaps(staticEntity.getSensor()))
            {
                return true;
            }
        }
        return false;
    }

}
