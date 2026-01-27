package com.myname.game.entitiy;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PointMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.utils.Array;

public class EntityFactory {

    private TiledMap tiledMap;

    public EntityFactory(TiledMap tiledMap)
    {
        this.tiledMap = tiledMap;
    }

    public MapObject findPointEntity(String wantedClass, String wantedLayer)
    {
        for(MapObject object : tiledMap.getLayers().get(wantedLayer).getObjects().getByType(PointMapObject.class))
        {
            String objectType = object.getProperties().get("type", String.class);


            if(wantedClass.equals(objectType))
            {
                return object;
            }
        }

        return null;
    }

    public Array<MapObject> findTiledMapTiledObjects(String wantedClass, String wantedLayer)
    {
        Array<MapObject> staticEntities = new Array<>();

        for(MapObject object : tiledMap.getLayers().get(wantedLayer).getObjects().getByType(TiledMapTileMapObject.class))
        {
            String objectType = object.getProperties().get("type", String.class);


            if(wantedClass.equals(objectType))
            {
                staticEntities.add(object);
            }
        }

        return staticEntities;
    }

}
