package com.fixertin.gdxTest.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.fixertin.gdxTest.util.Renderable;

public class Entity implements Renderable{
    public Vector2 position, velocity;
    public Rectangle boundingBox;

    public Entity(float x, float y, float velx, float vely, float width, float height){
        position = new Vector2(x, y);
        velocity = new Vector2(velx, vely);
        boundingBox = new Rectangle(x - width / 2, y - height / 2, width, height);
    }
    public Entity(float x, float y, float width, float height){

    }

    public void update(float deltaTime){
        position.mulAdd(velocity, deltaTime);
    }

    @Override
    public void render(Batch batch, float deltaTime) {
        update(deltaTime);
        batch.begin();

        batch.end();
    }
}
