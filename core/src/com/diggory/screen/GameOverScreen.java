/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
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
public class GameOverScreen extends Screen {
    
    private OrthoCamera camera;
    private final Texture texture;
    private final Sound sound;
    final Sound music;
    
    public GameOverScreen(boolean won) {
        if (won) {
            texture = TextureManager.WINNER;
            sound = SoundManager.WON;
            music = SoundManager.WIN_MUSIC;
        }
        else {
            texture = TextureManager.GAMEOVER;
            sound = SoundManager.DEATH;
            music = SoundManager.LOSE_MUSIC;
        }
    }

    @Override
    public void create() {
        SoundManager.GAME_MUSIC.stop();
        camera = new OrthoCamera();
        camera.resize();
        sound.play();
        music.loop();
    }

    @Override
    public void update() {
        camera.update();
        if (Gdx.input.isKeyPressed(Keys.BACKSPACE)) {
            music.stop();
            Diggory_Game diggory = new Diggory_Game();
            diggory.create();
            diggory.render();
            diggory.resize(Diggory.WIDTH, Diggory.HEIGHT);
        }
        else if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            music.stop();
            Diggory diggory = new Diggory();
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
