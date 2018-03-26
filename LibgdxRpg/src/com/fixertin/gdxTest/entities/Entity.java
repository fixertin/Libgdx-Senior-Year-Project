package com.fixertin.gdxTest.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.fixertin.gdxTest.util.Renderable;

public class Entity implements Renderable{
    public Vector2 position, velocity;

    public void update(float deltaTime){
        position.mulAdd(velocity, deltaTime);
    }

    @Override
    public void Render(Batch batch, float deltaTime) {
        update(deltaTime);
    }
}
