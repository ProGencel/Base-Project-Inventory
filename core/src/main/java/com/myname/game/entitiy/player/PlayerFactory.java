package com.myname.game.entitiy.player;

import com.badlogic.gdx.maps.objects.PointMapObject;
import com.myname.game.entitiy.EntityFactory;

public class PlayerFactory {

    private PointMapObject pointMapObject;

    public PlayerFactory(EntityFactory factory)
    {
        setPlayer(factory);
    }

    private void setPlayer(EntityFactory factory)
    {
        pointMapObject = (PointMapObject) factory.findPointEntity("Player","EntityReferences");

        if(pointMapObject == null){System.out.println("Player could not be configured");}
    }


    public PointMapObject getPlayer()
    {
        return pointMapObject;
    }

}
