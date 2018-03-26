package com.fixertin.gdxTest.main;

import com.badlogic.gdx.Game;
import com.fixertin.gdxTest.screens.GameScreen;

public class RpgGame extends Game{
    public static GameScreen MAIN_GAME_SCREEN;


    @Override
    public void create() {
        MAIN_GAME_SCREEN = new GameScreen();
        setScreen(MAIN_GAME_SCREEN);
    }

    @Override
    public void dispose() {
        MAIN_GAME_SCREEN.dispose();
    }
}
