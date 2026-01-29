package com.myname.game.entitiy.player;

import com.badlogic.gdx.utils.Array;
import com.myname.game.entitiy.GameEntity;
import com.myname.game.entitiy.collision.CollisionManager;
import com.myname.game.events.InputEvent;
import com.myname.game.events.InputListener;
import com.myname.game.events.ItemEvent;
import com.myname.game.events.ItemEventManager;

public class PlayerUpdate implements InputListener { //Sonradan tum player update tasinacak

    private Player player;
    private Array<GameEntity> obstacles;

    public void playerUpdate(Player player, Array<GameEntity> obstacles)
    {
        this.player = player;
        this.obstacles = obstacles;
        ItemEventManager.subscribeInput(this);
    }

    @Override
    public void answerEventOnInput(InputEvent inputEvent) {

        if(CollisionManager.isWillCollisionSensor(player.getRectangle(),obstacles))
        {
            ItemEventManager.newEvent(new ItemEvent("pot"));
        }
    }
}
