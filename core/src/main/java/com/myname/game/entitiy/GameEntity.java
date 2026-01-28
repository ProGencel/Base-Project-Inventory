package com.myname.game.entitiy;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.myname.game.interfaces.Colladable;

public class GameEntity implements Colladable {

    public Vector2 velocity;
    public Rectangle rectangle;

    protected GameEntity()
    {
        velocity = new Vector2(0,0);
    }

    @Override
    public Rectangle getFutureRectangle() {
        return null;
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }
}
