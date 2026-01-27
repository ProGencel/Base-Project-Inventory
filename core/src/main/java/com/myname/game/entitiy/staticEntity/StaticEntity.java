package com.myname.game.entitiy.staticEntity;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Vector2;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Drawable;
import com.myname.game.utils.Constants;

public class StaticEntity extends GameEntity implements Drawable {

    private TextureRegion textureRegion;
    private final Vector2 position;
    private float width;
    private float height;

    public StaticEntity(MapObject mapObject)
    {
        position = new Vector2();

        setProps((TiledMapTileMapObject) mapObject);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(textureRegion,position.x,position.y,width,height);
    }

    private void setProps(TiledMapTileMapObject mapObject)
    {
        textureRegion = mapObject.getTextureRegion();
        position.x = mapObject.getX() * Constants.PPM;
        position.y = mapObject.getY() * Constants.PPM;
        width = textureRegion.getRegionWidth() * Constants.PPM;
        height = textureRegion.getRegionHeight() * Constants.PPM;

    }
}
