package com.myname.game.entitiy.staticEntity;

import static com.myname.game.utils.Constants.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Drawable;
import com.myname.game.utils.Constants;

public class StaticEntity extends GameEntity implements Drawable {

    private TextureRegion textureRegion;
    private final Vector2 position;
    private float width;
    private float height;
    private Rectangle sensor;

    public Vector2 getPosition()
    {
        return position;
    }

    public Rectangle getSensor()
    {
        return sensor;
    }

    public StaticEntity(MapObject mapObject)
    {
        position = new Vector2();
        sensor = new Rectangle();

        setProps((TiledMapTileMapObject) mapObject);
        setRectangle((TiledMapTileMapObject) mapObject);
        setSensor();
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(textureRegion,position.x,position.y,width,height);
    }

    private void setProps(TiledMapTileMapObject mapObject)
    {
        textureRegion = mapObject.getTextureRegion();
        position.x = mapObject.getX() * PPM;
        position.y = mapObject.getY() * PPM;
        width = textureRegion.getRegionWidth() * PPM;
        height = textureRegion.getRegionHeight() * PPM;
    }

    private void setSensor()
    {
        sensor.x = rectangle.x - STATIC_ENTITY_SENSOR_OFFSET_X_Y;
        sensor.y = rectangle.y - STATIC_ENTITY_SENSOR_OFFSET_X_Y;
        sensor.width = rectangle.width + STATIC_ENTITY_SENSOR_OFFSET_WIDTH_AND_HEIGHT;
        sensor.height = rectangle.height + STATIC_ENTITY_SENSOR_OFFSET_WIDTH_AND_HEIGHT;
    }

    private void setRectangle(TiledMapTileMapObject mapObject)
    {
        for(MapObject object : mapObject.getTile().getObjects())
        {
            if(object instanceof RectangleMapObject)
            {
                RectangleMapObject recObject = (RectangleMapObject) object;

                //Orijinal rectangle i bozmuyoruz kopyasini olusturuyoruz
                Rectangle localRect = recObject.getRectangle();

                this.rectangle = new Rectangle((localRect.x * PPM) + position.x,
                    (localRect.y * PPM) + position.y,
                    localRect.width * PPM,
                    localRect.height * PPM);
            }
        }
    }
}
