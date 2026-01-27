package com.myname.game.screens.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Disposable;
import com.myname.game.entitiy.player.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myname.game.entitiy.staticEntity.StaticEntityCreator;
import com.myname.game.tools.GameCamera;
import com.myname.game.tools.MapManager;

public class DrawGameScreen implements Disposable {

    private MapManager mapManager;
    private GameCamera camera;
    private Player player;
    private StaticEntityCreator staticEntityCreator;

    private SpriteBatch batch;

    public DrawGameScreen(MapManager mapManager, Player player, GameCamera camera,
                          StaticEntityCreator staticEntityCreator)
    {
        batch = new SpriteBatch();

        this.mapManager = mapManager;
        this.player = player;
        this.staticEntityCreator = staticEntityCreator;
        this.camera = camera;
    }

    public void drawGameScreen()
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.orthographicCamera.combined);
        batch.begin();

        mapManager.draw(batch);
        player.draw(batch);
        staticEntityCreator.draw(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
