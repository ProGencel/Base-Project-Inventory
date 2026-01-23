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
import com.myname.game.interfaces.Renderable;

public class Player extends GameEntity implements Drawable, Renderable {

    private Texture texture;
    private TextureRegion textureRegion;

    private PlayerFactory playerFactory;
    private PlayerInputHandler inputHandler;

    private PointMapObject playerProps;

    public Vector2 position;
    private float width;
    private float height;

    public Player(AssetManager manager, EntityFactory factory) {
        super(manager);

        texture = manager.get("Player/PlayerIdle.png");
        textureRegion = new TextureRegion(texture);

        playerFactory = new PlayerFactory(factory);
        inputHandler = new PlayerInputHandler(this);
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

    @Override
    public void render(float dt) {
        inputHandler.render(dt);
    }
}
