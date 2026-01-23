package com.myname.game.entitiy.player;

import static com.myname.game.utils.Constants.*;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.PointMapObject;
import com.badlogic.gdx.math.Vector2;
import com.myname.game.entitiy.EntityFactory;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Drawable;

public class Player extends GameEntity implements Drawable {

    private Texture texture;
    private TextureRegion textureRegion;

    private PlayerFactory playerFactory;

    private PointMapObject playerProps;
    public Vector2 position;
    private float width;
    private float height;

    public Player(AssetManager manager, EntityFactory factory) {
        super(manager);

        texture = manager.get("Player/PlayerIdle.png");
        textureRegion = new TextureRegion(texture);

        playerFactory = new PlayerFactory(factory);
        playerProps = playerFactory.getPlayer();

        position = playerProps.getPoint();


        width = textureRegion.getRegionWidth() * PPM;
        height = textureRegion.getRegionHeight() * PPM;

        position.x *= PPM;
        position.x -= width/2;

        position.y *= PPM;
        position.y -= height/2;
    }

    @Override
    public void draw(SpriteBatch batch) {

        batch.draw(textureRegion,position.x,position.y,width,height);

    }
}
