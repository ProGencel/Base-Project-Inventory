package com.myname.game.entitiy.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.myname.game.interfaces.Renderable;
import com.myname.game.utils.Constants;

public class PlayerInputHandler implements Renderable {

    public PlayerState playerState;
    private Player player;

    public PlayerInputHandler(Player player)
    {
        playerState = PlayerState.RIGHT;
        this.player = player;
    }

    @Override
    public void render(float dt) {
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            player.position.y += Constants.PLAYER_SPEED;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            player.position.y -= Constants.PLAYER_SPEED;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            player.position.x -= Constants.PLAYER_SPEED;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            player.position.x += Constants.PLAYER_SPEED;
        }
    }
}
