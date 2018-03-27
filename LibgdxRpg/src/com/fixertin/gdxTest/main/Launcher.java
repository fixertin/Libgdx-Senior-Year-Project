package com.fixertin.gdxTest.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1024;
        config.height = 576;
        config.backgroundFPS = 60;
        config.foregroundFPS = 60;

        new LwjglApplication(new RpgGame(), config);
    }
}
