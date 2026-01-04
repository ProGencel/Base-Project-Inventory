package com.myname.game.screens.gameScreen.tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.maps.Map;

public class MapManager {

    private Map map;

    public MapManager(AssetManager assetManager)
    {
        map = assetManager.get("World/world.tmx");
    }

}
