/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.diggory.Diggory;
import com.diggory.SoundManager;
import com.diggory.TextureManager;

/**
 *
 * @author Scott Goodman
 */
public class Player extends Entity {

    private final EntityManager entityManager;
    private long lastFire;
    
    public Player(Vector2 pos, Vector2 direction, EntityManager entityManager) {
        super(TextureManager.PLAYER, pos, direction);
        this.entityManager = entityManager;
    }

    @Override
    public void update() {
        checkBounds();
        pos.add(direction);
        setMovement();
    }
    
    public void checkBounds() {
        if (pos.y + direction.y < 0) {
            if (direction.y < 0) {
                direction.y = 0;
            }
            pos.y = 0;
        }
        if (pos.y + direction.y > Diggory.HEIGHT - TextureManager.PLAYER.getHeight()) {
            if (direction.y > 0) {
                direction.y = 0;
            }
            pos.y = Diggory.HEIGHT - TextureManager.PLAYER.getHeight();
        }
        if (pos.x + direction.x < 0) {
            if (direction.x < 0) {
                direction.x = 0;
            }
            pos.x = 0;
        }
        if (pos.x + direction.x > Diggory.WIDTH - TextureManager.PLAYER.getWidth()) {
            if (direction.x > 0) {
                direction.x = 0;
            }
            pos.x = Diggory.WIDTH - TextureManager.PLAYER.getWidth();
        }
    }
    
    public void setMovement() {
        if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)) {
            setDirection(-300, 300);
        }        
        else if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.S)) {
            setDirection(0, 0);
        }        
        else if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
            setDirection(300, 300);
        }        
        else if (Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.S)) {
            setDirection(-300, -300);
        }        
        else if (Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.D)) {
            setDirection(-0, 0);
        }        
        else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)) {
            setDirection(300, -300);
        }        
        else if (Gdx.input.isKeyPressed(Keys.W)) {
            setDirection(0, 300);
        }        
        else if (Gdx.input.isKeyPressed(Keys.A)) {
            setDirection(-300, 0);
        }        
        else if (Gdx.input.isKeyPressed(Keys.S)) {
            setDirection(0, -300);
        }        
        else if (Gdx.input.isKeyPressed(Keys.D)) {
            setDirection(300, 0);
        }        
        else {
            setDirection(0,0);
        }       
        
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            if (System.currentTimeMillis() - lastFire >= 200) {
                Vector2 missileDir = new Vector2((direction.x / 2) + 5, direction.y / 2);
                entityManager.addEntity(new Missile(TextureManager.MISSILE_RIGHT, pos.cpy().add(100, 20), missileDir));
                lastFire = System.currentTimeMillis();
                SoundManager.PEW.play();
            }
        }        
        else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            if (System.currentTimeMillis() - lastFire >= 200) {
                Vector2 missileDir = new Vector2((direction.x / 2) - 5, direction.y / 2);
                entityManager.addEntity(new Missile(TextureManager.MISSILE_LEFT, pos.cpy().add(100, 20), missileDir));
                lastFire = System.currentTimeMillis();
                SoundManager.PEW.play();
            }
        }       
        else if (Gdx.input.isKeyPressed(Keys.UP)) {
            if (System.currentTimeMillis() - lastFire >= 200) {
                Vector2 missileDir = new Vector2(direction.x / 2, (direction.y / 2) + 5);
                entityManager.addEntity(new Missile(TextureManager.MISSILE_UP, pos.cpy().add(100, 20), missileDir));
                lastFire = System.currentTimeMillis();
                SoundManager.PEW.play();
            }
        }
        else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            if (System.currentTimeMillis() - lastFire >= 200) {
                Vector2 missileDir = new Vector2(direction.x / 2, (direction.y / 2) - 5);
                entityManager.addEntity(new Missile(TextureManager.MISSILE_DOWN, pos.cpy().add(100, 20), missileDir));
                lastFire = System.currentTimeMillis();
                SoundManager.PEW.play();
            }
        }
    }
    
}
