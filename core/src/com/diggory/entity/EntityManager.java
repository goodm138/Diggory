/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.diggory.Diggory;
import com.diggory.SoundManager;
import com.diggory.TextureManager;
import com.diggory.screen.GameOverScreen;
import com.diggory.screen.ScreenManager;

/**
 *
 * @author Scott Goodman
 */
public class EntityManager {
    
    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;
    
    public EntityManager(int amount) {
        float px = Diggory.WIDTH / 2 - TextureManager.PLAYER.getWidth() / 2;
        player = new Player(new Vector2(px, 0), new Vector2(0,0), this);
        for (int i = 0; i < amount; i++) {
            float y = MathUtils.random(0, Diggory.HEIGHT - TextureManager.ENEMY.getHeight());
            float dir = MathUtils.random(0, 10);
            if (dir > 5) {
                float x = MathUtils.random(Diggory.WIDTH, Diggory.WIDTH * 2);
                float speed = MathUtils.random(2, 5);
                addEntity(new Enemy(TextureManager.ENEMY, new Vector2(x, y), new Vector2(-speed, 0)));
            }
            else {
                float x = MathUtils.random(-Diggory.WIDTH - TextureManager.ENEMY.getWidth(), -TextureManager.ENEMY.getWidth());
                float speed = MathUtils.random(2, 5);
                addEntity(new Enemy(TextureManager.ENEMY_RIGHT, new Vector2(x, y), new Vector2(speed, 0)));
            }            
        }
    }
    
    public void update() {
        for (Entity e : entities) {
            e.update();
        }
        for (Missile m : getMissiles())
        {
            if (m.checkEnd()) {
                entities.removeValue(m, false);
            }
        }
        player.update();
        checkCollisions();
    }
    
    public void render(SpriteBatch sb) {
        for (Entity e : entities) {
            e.render(sb);
        }
        player.render(sb);
    }
    
    private void checkCollisions() {
        for (Enemy e : getEnemies()) {
            for (Missile m : getMissiles()) {
                if (e.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(e, false);
                    entities.removeValue(m, false);
                    SoundManager.HIT.play();
                    if (gameOver()) {
                        ScreenManager.setScreen(new GameOverScreen(true));
                    }
                }
            }   
            if (e.getBounds().overlaps(player.getBounds())) {
            ScreenManager.setScreen(new GameOverScreen(false));
            }
        }
    }
    
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    private Array<Enemy> getEnemies() {
        Array<Enemy> ret = new Array<Enemy>();
        for (Entity e : entities) {
            if (e instanceof Enemy) {
                ret.add((Enemy) e);
            }
        }
        return ret;
    }
    
    private Array<Missile> getMissiles() {
        Array<Missile> ret = new Array<Missile>();
        for (Entity e : entities) {
            if (e instanceof Missile) {
                ret.add((Missile) e);
            }
        }
        return ret;
    }
    
    public boolean gameOver() {
        return getEnemies().size <= 0;
    }
    
}
