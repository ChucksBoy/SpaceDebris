package com.chucksboy.spacedebris.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import static com.badlogic.gdx.physics.box2d.BodyDef.BodyType.KinematicBody;
import static com.chucksboy.spacedebris.screen.Game.WORLD;

public class Typhon extends Sprite implements UpdateableSprite{
    private static final String SHIP_GRAPHIC = "sprites/typhon.png";
    private static final float acceleration = 25;

    private Body body;

    public Typhon(Vector2 startPosition) {
        super(new Texture(SHIP_GRAPHIC));
        body = createBody(startPosition);
        setRotation(270);
        setCenter(startPosition.x, startPosition.y);
    }

    private Body createBody(Vector2 startPosition) {
        BodyDef definition = new BodyDef();
        definition.type = KinematicBody;
        definition.position.set(startPosition);
        return WORLD.createBody(definition);
    }

    public Vector2 getPosition() {
        return new Vector2(getX(), getY());
    }

    public void moveUp() {
        Vector2 upForce = new Vector2(0, acceleration);
        body.applyForceToCenter(upForce, true);
    }

    public void moveDown() {
        Vector2 downForce = new Vector2(0, -acceleration);
        body.applyForceToCenter(downForce, true);
    }

    @Override
    public void update(float delta) {
        setCenter(getX(), body.getPosition().y);
    }
}
