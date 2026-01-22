package com.myname.game.entitiy.player;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Drawable;

public class Player extends GameEntity implements Drawable {

    private Texture texture;
    private TextureRegion textureRegion;

    private PlayerFactory playerFactory;

    public Player(AssetManager manager, TiledMap tiledMap) {
        super(manager);

        playerFactory = new PlayerFactory(tiledMap);

        texture = manager.get("Player/PlayerIdle.png");
        textureRegion = new TextureRegion(texture);
    }

    @Override
    public void draw(SpriteBatch batch) {

        batch.begin();

        batch.draw(textureRegion,10,10);

        batch.end();
    }
}
