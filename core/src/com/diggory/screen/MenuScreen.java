/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.diggory.Diggory;
import com.diggory.Diggory_Game;
import com.diggory.SoundManager;
import com.diggory.TextureManager;
import com.diggory.camera.OrthoCamera;

/**
 *
 * @author Scott Goodman
 */
public class MenuScreen extends Screen {
    
    private OrthoCamera camera;
    private final Texture texture;
    
    public MenuScreen() {
        texture = TextureManager.MENU;
    }

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
        SoundManager.TITLE_MUSIC.loop();
    }

    @Override
    public void update() {
        camera.update();
        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            SoundManager.TITLE_MUSIC.stop();
            Diggory_Game diggory = new Diggory_Game();
            diggory.create();
            diggory.render();
            diggory.resize(Diggory.WIDTH, Diggory.HEIGHT);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(texture, Diggory.WIDTH / 2 - texture.getWidth() / 2, Diggory.HEIGHT / 2 - texture.getHeight() / 2);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
    
}
