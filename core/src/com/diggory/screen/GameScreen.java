/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.diggory.SoundManager;
import com.diggory.TextureManager;
import com.diggory.camera.OrthoCamera;
import com.diggory.entity.EntityManager;

/**
 *
 * @author Scott Goodman
 */
public class GameScreen extends Screen {

    private OrthoCamera camera;
    private EntityManager entityManager;
    
    @Override
    public void create() {
        SoundManager.GAME_MUSIC.loop();
        camera = new OrthoCamera();
        entityManager = new EntityManager(25);
    }    
    
    @Override
    public void update() {
        camera.update();
        entityManager.update();
    }
    
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(TextureManager.BACKGROUND, 0, 0);
        entityManager.render(sb);
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
