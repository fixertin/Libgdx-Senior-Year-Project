package com.fixertin.gdxTest.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface Renderable {
    public void render(Batch batch, ShapeRenderer sp, float deltaTime);
}
