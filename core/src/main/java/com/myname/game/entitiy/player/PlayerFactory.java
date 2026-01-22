package com.myname.game.entitiy.player;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PointMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class PlayerFactory {

    private float playerBegX;
    private float playerBegY;

    public PlayerFactory(TiledMap tiledMap)
    {

    }

    private PointMapObject findPlayer(TiledMap tiledMap)
    {
        for(MapObject object : tiledMap.getLayers().get("EntityReferences").getObjects().getByType(PointMapObject.class))
        {
            String objectType = object.getProperties().get("Class", String.class);

            if("Player".equals(objectType))
            {
                playerBegX = object
            }
        }


    }
}
