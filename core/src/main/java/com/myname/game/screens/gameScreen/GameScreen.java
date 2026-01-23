package com.myname.game.screens.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.myname.game.entitiy.EntityFactory;
import com.myname.game.entitiy.player.Player;
import com.myname.game.tools.GameCamera;
import com.myname.game.tools.MapManager;


public class GameScreen implements Screen {

    private DrawGameScreen gameScreenDrawer;
    private RenderGameScreen renderGameScreen;

    private MapManager mapManager;
    private GameCamera gameCamera;

    private Player player;

    private AssetManager assetManager;

    private EntityFactory factory;

    public GameScreen(AssetManager assetManager)
    {
        this.assetManager = assetManager;

        mapManager = new MapManager(assetManager);
        gameCamera = new GameCamera();

        factory = new EntityFactory(mapManager.tiledMap);
        player = new Player(assetManager,factory);

        gameScreenDrawer = new DrawGameScreen(mapManager,player,gameCamera);
        renderGameScreen = new RenderGameScreen(mapManager,gameCamera);
    }

    @Override
    public void show() {

    }

    public void draw()
    {
        gameScreenDrawer.drawGameScreen();
    }

    @Override
    public void render(float delta) {
        renderGameScreen.renderGameScreen(delta);

        gameCamera.cameraUpdate(player);
        player.render(delta);

        this.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameCamera.viewportUpdate(width, height);
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
        assetManager.dispose();
        mapManager.dispose();
    }
}
