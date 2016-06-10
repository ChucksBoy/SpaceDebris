package com.chucksboy.spacedebris;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chucksboy.spacedebris.screen.Game;

;

public class SpaceDebrisMain extends com.badlogic.gdx.Game {
	SpriteBatch batch;
    private final AssetManager assets = new AssetManager();

	@Override
	public void create () {
        batch = new SpriteBatch();
        setScreen(new Game(this));
	}

    @Override public void dispose() {
        batch.dispose();
        assets.dispose();
        super.dispose();
    }

    public AssetManager getAssets() {
        return assets;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
