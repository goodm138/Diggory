/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Scott Goodman
 */
public class Trophy extends Entity {
    
    public boolean landed = false;
    
    public Trophy(Texture texture, Vector2 pos, Vector2 direction) {
        super(texture, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);
        if (pos.y <= 0) {
            direction.y = 0;
            landed = true;
        }
    }
    
}
