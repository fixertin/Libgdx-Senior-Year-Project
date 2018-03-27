package com.fixertin.gdxTest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fixertin.gdxTest.entities.Entity;
import com.fixertin.gdxTest.util.InputController;
import com.fixertin.gdxTest.util.Unit;

import java.util.ArrayList;

public class TestScreen implements Screen {
    private static final String TAG = TestScreen.class.getSimpleName();
    private OrthographicCamera camera = null;
    private Batch batch = new SpriteBatch();

    private ShapeRenderer sp = new ShapeRenderer();

    public ArrayList<Entity> entities = new ArrayList<Entity>();


    private static class VIEWPORT{
        static float viewportWidth;
        static float viewportHeight;
        static float virtualWidth;
        static float virtualHeight;
        static float physicalWidth;
        static float physicalHeight;
        static float aspectRatio;

    }

    public TestScreen(){
        setupViewport(10,10);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT.viewportWidth,
                VIEWPORT.viewportHeight);

    }

    @Override
    public void show() {



        //player = new Entity();

        //currentPlayerSprite = player.getFrameSprite();

        //controller = new PlayerController(player);
        //Gdx.input.setInputProcessor(controller);
    }

    private int testx=10, testy=10;
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(0,
                0, 0f);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        sp.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.end();

        sp.begin(ShapeRenderer.ShapeType.Line);
        sp.setColor(Color.RED);
        sp.rect(0, 0, 10/ Unit.PPM, 10/ Unit.PPM);
        sp.rect(10/Unit.PPM, 10/Unit.PPM, 10/ Unit.PPM, 10/ Unit.PPM);
        sp.end();



        if(Gdx.input.justTouched()) {
            testx += 10;
            testy += 10;
            Entity en = new Entity(testx / Unit.PPM, testy / Unit.PPM, 0, 0, 10 / Unit.PPM, 10 / Unit.PPM);
            entities.add(en);
        }


        for(Entity e : entities){
            e.render(batch, sp, Gdx.graphics.getDeltaTime());
        }

    }

    @Override
    public void resize(int width, int height) {
        setupViewport(10, 10);
        camera.setToOrtho(false, VIEWPORT.viewportWidth, VIEWPORT.viewportHeight);
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

    }
    private void setupViewport(int width, int height){
        //Make the viewport a percentage of the total display area
        VIEWPORT.virtualWidth = width;
        VIEWPORT.virtualHeight = height;

        //Current viewport dimensions
        VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
        VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;

        //pixel dimensions of display
        VIEWPORT.physicalWidth = Gdx.graphics.getWidth();
        VIEWPORT.physicalHeight = Gdx.graphics.getHeight();

        //aspect ratio for current viewport
        VIEWPORT.aspectRatio = (VIEWPORT.virtualWidth / VIEWPORT.virtualHeight);

        //update viewport if there could be skewing
        if( VIEWPORT.physicalWidth / VIEWPORT.physicalHeight >= VIEWPORT.aspectRatio){
            //Letterbox left and right
            VIEWPORT.viewportWidth = VIEWPORT.viewportHeight * (VIEWPORT.physicalWidth/ VIEWPORT.physicalHeight);
            VIEWPORT.viewportHeight = VIEWPORT.virtualHeight;
        }else{
            //letterbox above and below
            VIEWPORT.viewportWidth = VIEWPORT.virtualWidth;
            VIEWPORT.viewportHeight = VIEWPORT.viewportWidth * (VIEWPORT.physicalHeight/ VIEWPORT.physicalWidth);
        }



        Gdx.app.log(TAG, "WorldRenderer: virtual: (" + VIEWPORT.virtualWidth + "," + VIEWPORT.virtualHeight + ")" );
        Gdx.app.log(TAG, "WorldRenderer: viewport: (" + VIEWPORT.viewportWidth + "," + VIEWPORT.viewportHeight + ")" );
        Gdx.app.log(TAG, "WorldRenderer: physical: (" + VIEWPORT.physicalWidth + "," + VIEWPORT.physicalHeight + ")" );
    }
}
