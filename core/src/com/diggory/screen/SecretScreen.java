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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.diggory.Diggory;
import com.diggory.SoundManager;
import com.diggory.TextureManager;
import com.diggory.camera.OrthoCamera;
import com.diggory.entity.Player;

/**
 *
 * @author Scott Goodman
 */
public class SecretScreen extends Screen {
    
    private OrthoCamera camera;
    private Texture texture = TextureManager.ERROR;
    private final Player player;
    private boolean offScreen = false;
    private boolean eaten = false;
    private long timer = 0;
    
    public SecretScreen() {
        player = new Player(new Vector2(0, 0), new Vector2(0,0), null, TextureManager.ENEMY_RIGHT);
    }

    @Override
    public void create() {
        SoundManager.GAME_MUSIC.stop();
        camera = new OrthoCamera();
        camera.resize();
        SoundManager.SECRET.play();
        SoundManager.SECRET_MUSIC.loop();
    }

    @Override
    public void update() {
        camera.update();
        player.update();
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            SoundManager.SECRET_MUSIC.stop();
            Diggory diggory = new Diggory();
            diggory.create();
            diggory.render();
            diggory.resize(Diggory.WIDTH, Diggory.HEIGHT);
        }
        if ((player.pos.x + TextureManager.ENEMY_RIGHT.getWidth() >= Diggory.WIDTH) && !offScreen) {
            texture = TextureManager.SECRET2;
            player.pos.x = 0;
            SoundManager.SECRET_MUSIC.stop();
            SoundManager.SECRET_MUSIC_2.play();
            offScreen = true;
        }
        if (offScreen) {
            player.direction.x /= 8;
            player.direction.y /= 8;
        }
        if (((player.pos.x + TextureManager.ENEMY_RIGHT.getWidth() >= 1080) &&
                ((player.pos.y >= 120) && (player.pos.y <= 220)))
                && offScreen)
            {
                if (timer == 0) {
                    timer = System.currentTimeMillis();
                    texture = TextureManager.SAD;
                    player.tex = new TextureRegion(TextureManager.DOLAN);
                    eaten = true;
                    SoundManager.SECRET_MUSIC_2.stop();
                    SoundManager.WHY.play();
                }
            }
        if (eaten && (System.currentTimeMillis() - timer >= 2500)) {
            ScreenManager.setScreen(new GameScreen(true));
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(texture, Diggory.WIDTH / 2 - texture.getWidth() / 2, Diggory.HEIGHT / 2 - texture.getHeight() / 2);
        player.render(sb);
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
