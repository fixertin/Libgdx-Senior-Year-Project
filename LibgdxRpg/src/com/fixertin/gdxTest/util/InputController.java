package com.fixertin.gdxTest.util;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

public class InputController implements InputProcessor {
    private final static String TAG = InputController.class.getSimpleName();

    enum Keys{
        LEFT, RIGHT, UP, DOWN, QUIT
    }
    enum Mouse{
        SELECT, DOACTION
    }

    public static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
    public static Map<Mouse, Boolean> mouseButtons = new HashMap<Mouse, Boolean>();
    private Vector3 lastMouseCoordinates;

    static{
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
        keys.put(Keys.QUIT, false);
    };
    static{
      mouseButtons.put(Mouse.SELECT, false);
      mouseButtons.put(Mouse.DOACTION, false);
    };

    @Override
    public boolean keyDown(int keycode) {
        if( keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            keys.put(Keys.LEFT, true);
        }
        if( keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            keys.put(Keys.RIGHT, true);
        }
        if( keycode == Input.Keys.UP || keycode == Input.Keys.W){
            keys.put(Keys.UP, true);
        }
        if( keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            keys.put(Keys.DOWN, true);
        }
        if( keycode == Input.Keys.ESCAPE){
            keys.put(Keys.QUIT, true);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if( keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
            keys.put(Keys.LEFT, false);
        }
        if( keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
            keys.put(Keys.RIGHT, false);
        }
        if( keycode == Input.Keys.UP || keycode == Input.Keys.W){
            keys.put(Keys.UP, false);
        }
        if( keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
            keys.put(Keys.DOWN, false);
        }
        if( keycode == Input.Keys.ESCAPE){
            keys.put(Keys.QUIT, false);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if( button == Input.Buttons.LEFT || button ==
                Input.Buttons.RIGHT ){
            lastMouseCoordinates.set(screenX, screenY, 0);
        }
        //left is selection, right is context menu
        if( button == Input.Buttons.LEFT){
            mouseButtons.put(Mouse.SELECT, true);
        }
        if( button == Input.Buttons.RIGHT){
            mouseButtons.put(Mouse.DOACTION, true);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer,
                             int button) {
        if( button == Input.Buttons.LEFT || button ==
                Input.Buttons.RIGHT ){
            lastMouseCoordinates.set(screenX, screenY, 0);
        }
        //left is selection, right is context menu
        if( button == Input.Buttons.LEFT){
            mouseButtons.put(Mouse.SELECT, false);
        }
        if( button == Input.Buttons.RIGHT){
            mouseButtons.put(Mouse.DOACTION, false);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
