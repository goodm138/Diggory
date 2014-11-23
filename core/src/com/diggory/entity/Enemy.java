/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.diggory.Diggory;
import com.diggory.TextureManager;

/**
 *
 * @author Scott Goodman
 */
public class Enemy extends Entity{

    public Enemy(Texture texture, Vector2 pos, Vector2 direction) {
        super(texture, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);
        float y = MathUtils.random(0, Diggory.HEIGHT - TextureManager.ENEMY.getHeight());
        if (direction.x < 0) {
            if (pos.x <= -TextureManager.ENEMY.getWidth()) {
                pos.set(Diggory.WIDTH, y);
            }
        }
        else {
            if (pos.x >= Diggory.WIDTH) {
                pos.set(-TextureManager.ENEMY.getWidth(),y);
            }
        }
    }
    
}
