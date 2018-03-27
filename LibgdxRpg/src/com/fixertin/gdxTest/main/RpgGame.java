package com.fixertin.gdxTest.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.fixertin.gdxTest.screens.DialogScreen;
import com.fixertin.gdxTest.screens.GameScreen;
import com.fixertin.gdxTest.screens.TestScreen;
import com.fixertin.gdxTest.util.InputController;

public class RpgGame extends Game{
    public static GameScreen MAIN_GAME_SCREEN;
    public static TestScreen TEST_SCREEN;
    public static DialogScreen DIALOG_SCREEN;


    @Override
    public void create() {
        MAIN_GAME_SCREEN = new GameScreen();
        TEST_SCREEN = new TestScreen();
        DIALOG_SCREEN = new DialogScreen();
        setScreen(DIALOG_SCREEN);
    }

    @Override
    public void dispose() {
        MAIN_GAME_SCREEN.dispose();
        TEST_SCREEN.dispose();
        DIALOG_SCREEN.dispose();
    }
}
