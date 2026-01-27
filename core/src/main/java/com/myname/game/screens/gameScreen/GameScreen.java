package com.myname.game.screens.gameScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.myname.game.entitiy.EntityFactory;
import com.myname.game.entitiy.player.Player;
import com.myname.game.entitiy.staticEntity.StaticEntityCreator;
import com.myname.game.tools.GameCamera;
import com.myname.game.tools.MapManager;


public class GameScreen implements Screen {

    private DrawGameScreen gameScreenDrawer;
    private UpdateGameScreen updateGameScreen;

    private MapManager mapManager;
    private GameCamera gameCamera;

    private Player player;
    private StaticEntityCreator staticEntityCreator;

    private AssetManager assetManager;

    private EntityFactory factory;

    public GameScreen(AssetManager assetManager)
    {
        this.assetManager = assetManager;

        mapManager = new MapManager(assetManager);
        gameCamera = new GameCamera();

        factory = new EntityFactory(mapManager.tiledMap);
        player = new Player(assetManager,factory);
        staticEntityCreator = new StaticEntityCreator(factory);

        gameScreenDrawer = new DrawGameScreen(mapManager,player,gameCamera,staticEntityCreator);
        updateGameScreen = new UpdateGameScreen(mapManager,gameCamera,player);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        player.update(delta);

        updateGameScreen.updateGameScreen(delta);

        gameScreenDrawer.drawGameScreen();
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
        gameScreenDrawer.dispose();
    }
}
