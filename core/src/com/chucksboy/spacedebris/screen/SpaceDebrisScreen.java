package com.chucksboy.spacedebris.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.chucksboy.spacedebris.SpaceDebrisMain;

import java.util.ArrayList;
import java.util.List;

public abstract class SpaceDebrisScreen implements Screen {

    protected final SpaceDebrisMain main;
    protected final OrthographicCamera camera;
    protected final Viewport viewport;
    protected final SpriteBatch batch;
    protected final Texture background;

    protected Music music;
    protected List<Sprite> sprites;

    public SpaceDebrisScreen(SpaceDebrisMain main) {
        this.main = main;
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(1100, 640, camera);
        batch = main.getBatch();
        sprites = new ArrayList<Sprite>();
        background = setBackgroundTexture();
    }

    protected abstract Texture setBackgroundTexture();

    protected abstract void update(float delta);

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);

        clearScreen();

        batch.begin();

        drawBackground(batch);
        for (Sprite sprite : sprites) {
            sprite.draw(batch);
        }

        batch.end();
    }

    protected abstract void drawBackground(SpriteBatch batch);

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        background.dispose();
        for (Sprite sprite : sprites) {
            sprite.getTexture().dispose();
        }
    }
}
