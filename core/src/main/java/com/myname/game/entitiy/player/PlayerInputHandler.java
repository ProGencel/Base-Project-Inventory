package com.myname.game.entitiy.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.myname.game.interfaces.UpdateAble;
import com.myname.game.utils.Constants;

public class PlayerInputHandler implements UpdateAble {

    public PlayerState playerState;
    private Player player;

    public PlayerInputHandler(Player player)
    {
        playerState = PlayerState.RIGHT;
        this.player = player;
    }

    @Override
    public void update(float dt) {

        player.velocity.set(0,0);

        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            player.velocity.y = Constants.PLAYER_SPEED * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            player.velocity.y = -Constants.PLAYER_SPEED * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            player.velocity.x = -Constants.PLAYER_SPEED * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            player.velocity.x = Constants.PLAYER_SPEED * dt;
        }

        if(!player.velocity.isZero())
        {
            player.velocity.nor().scl(Constants.PLAYER_SPEED);
        }
    }
}
