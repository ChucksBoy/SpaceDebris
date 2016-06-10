package com.chucksboy.spacedebris.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.chucksboy.spacedebris.SpaceDebrisMain;
import com.chucksboy.spacedebris.sprite.Typhon;
import com.chucksboy.spacedebris.sprite.UpdateableSprite;

import static com.badlogic.gdx.Gdx.input;

public class Game extends SpaceDebrisScreen {

    public static final World WORLD = new World(new Vector2(0,0), true);
    private static final int VELOCITY = 350;

    private Vector2 typhonStartPosition;
    private Typhon typhon;
    private float elapsedtime;

    public Game(SpaceDebrisMain main) {
        super(main);
        elapsedtime = 0;
        typhonStartPosition = new Vector2(20, 300);
        typhon = new Typhon(typhonStartPosition);
        sprites.add(typhon);
    }

    @Override
    protected Texture setBackgroundTexture() {
        return new Texture("starfield2.png");
    }

    @Override
    protected void update(float delta) {
        moveBackground(delta);

        parseInput();

        WORLD.step(1/60f, 6, 2);

        for (Sprite sprite : sprites) {
            if (sprite instanceof  UpdateableSprite )
                ((UpdateableSprite)sprite).update(delta);
        }
    }

    private void parseInput() {
        if (input.isTouched()) {
            if (typhon.getY() < input.getY())
                typhon.moveUp();
            if (typhon.getY() < input.getY())
                typhon.moveDown();
        }
    }

    private void moveBackground(float delta) {
        elapsedtime += VELOCITY * delta;
        if (elapsedtime > 2 * background.getWidth())
            elapsedtime -= background.getWidth() * 2;
    }

    private float getBackgroundPosition1() {
        if (elapsedtime >= background.getWidth())
            return 2 * background.getWidth() - elapsedtime;
        return -elapsedtime;
    }

    private float getBackgroundPosition2() {
        return background.getWidth() - elapsedtime;
    }

    @Override
    protected void drawBackground(SpriteBatch batch) {
        batch.draw(background,getBackgroundPosition1(),0);
        batch.draw(background,getBackgroundPosition2(),0);
    }
}
