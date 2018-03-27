package com.fixertin.gdxTest.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.fixertin.gdxTest.screens.GameScreen;
import com.fixertin.gdxTest.screens.TestScreen;
import com.fixertin.gdxTest.util.InputController;

public class RpgGame extends Game{
    public static GameScreen MAIN_GAME_SCREEN;
    public static TestScreen TEST_SCREEN;


    @Override
    public void create() {
        Gdx.input.setInputProcessor(new InputController());
        MAIN_GAME_SCREEN = new GameScreen();
        TEST_SCREEN = new TestScreen();
        setScreen(TEST_SCREEN);
    }

    @Override
    public void dispose() {
        MAIN_GAME_SCREEN.dispose();
        TEST_SCREEN.dispose();
    }
}
