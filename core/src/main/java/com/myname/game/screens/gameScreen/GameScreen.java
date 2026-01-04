package com.myname.game.screens.gameScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.myname.game.screens.gameScreen.tools.CameraManager;
import com.myname.game.screens.gameScreen.tools.MapManager;

public class GameScreen implements Screen {

    private CameraManager camManager;
    private MapManager mapManager;

    public GameScreen(AssetManager assetManager)
    {
        mapManager = new MapManager(assetManager);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
