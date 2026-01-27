package com.myname.game.entitiy.staticEntity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.utils.Array;
import com.myname.game.entitiy.EntityFactory;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Drawable;

public class StaticEntityCreator implements Drawable {

    private EntityFactory factory;
    private Array<MapObject> staticEntityObjects;
    private Array<GameEntity> staticEntities;

    public StaticEntityCreator(EntityFactory factory)
    {
        this.factory = factory;
        staticEntities = new Array<>();
        setEntities();
        createStaticEntities();
    }

    private void setEntities()
    {
        staticEntityObjects = factory.findTiledMapTiledObjects("Static","Objects");
    }

    private void createStaticEntities()
    {
        for(MapObject object : staticEntityObjects)
        {
            StaticEntity staticEntity = new StaticEntity(object);

            staticEntities.add(staticEntity);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(GameEntity entity : staticEntities)
        {
            StaticEntity staticEntity = (StaticEntity) entity;
            staticEntity.draw(batch);
        }
    }
}
