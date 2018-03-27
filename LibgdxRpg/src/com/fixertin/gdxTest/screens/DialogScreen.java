package com.fixertin.gdxTest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Json;
import com.fixertin.gdxTest.screens.dialog.DialogList;

import java.util.Stack;

public class DialogScreen implements Screen {
    private Stack<DialogList> dialogSections = new Stack<DialogList>();

    public DialogScreen(){

    }

    @Override
    public void show() {
        Json json = new Json();
        dialogSections.push(json.fromJson(DialogList.class, Gdx.files.internal("json/test.json")));
        System.out.println(dialogSections.peek().getDialogs().get(0).getSpeaker());
        System.out.println(dialogSections.peek().getDialogs().get(0).getText());
        System.out.println(dialogSections.peek().getDialogs().get(1).getSpeaker());
        System.out.println(dialogSections.peek().getDialogs().get(1).getText());
        System.out.println(dialogSections.peek().getDialogs().get(2).getSpeaker());
        System.out.println(dialogSections.peek().getDialogs().get(2).getText());
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
}
