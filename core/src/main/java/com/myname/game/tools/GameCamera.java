package com.myname.game.tools;

import static com.myname.game.utils.Constants.*;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.myname.game.entitiy.player.Player;


public class GameCamera {

    public OrthographicCamera orthographicCamera;

    private Viewport viewport;

    public GameCamera()
    {
        orthographicCamera = new OrthographicCamera();

        viewport = new FitViewport(SCREEN_WIDTH * PPM,SCREEN_HEIGHT * PPM,orthographicCamera);
    }

    public void viewportUpdate(int width,int height)
    {
        viewport.update(width, height);
    }

    public void cameraUpdate(Player player)
    {
        orthographicCamera.position.x = player.position.x;
        orthographicCamera.position.y = player.position.y;

        orthographicCamera.update();
    }
}
