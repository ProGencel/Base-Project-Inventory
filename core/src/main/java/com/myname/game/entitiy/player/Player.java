package com.myname.game.entitiy.player;

import static com.myname.game.utils.Constants.*;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.PointMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.myname.game.entitiy.EntityFactory;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.interfaces.Colladable;
import com.myname.game.interfaces.Drawable;
import com.myname.game.interfaces.UpdateAble;

public class Player extends GameEntity implements Drawable, UpdateAble, Colladable {

    private Texture texture;
    private TextureRegion textureRegion;

    private PlayerFactory playerFactory;
    private PlayerInputHandler inputHandler;

    private PointMapObject playerProps;

    private Vector2 position;
    private float width;
    private float height;

    private Rectangle rectangle;

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Player(AssetManager manager, EntityFactory factory) {
        super();

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

        rectangle = new Rectangle(position.x, position.y,
            width - PLAYER_HITBOX_OFFSET_WIDTH, height - PLAYER_HITBOX_OFFSET_HEIGHT);

    }

    @Override
    public void draw(SpriteBatch batch) {

        batch.draw(textureRegion,position.x,position.y,width,height);

    }

    @Override
    public void update(float dt) {
        inputHandler.update(dt);
        rectangle.x = position.x + PLAYER_HITBOX_OFFSET_X ;
        rectangle.y = position.y + PLAYER_HITBOX_OFFSET_Y;
    }
}
