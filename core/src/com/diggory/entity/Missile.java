/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.diggory.Diggory;

/**
 *
 * @author Scott Goodman
 */
public class Missile extends Entity {

    public Missile(Texture texture, Vector2 pos, Vector2 dir) {
        super(texture, pos, dir);
    }

    @Override
    public void update() {
        pos.add(direction);
    }
    
    public boolean checkEnd() {
        return pos.x >= Diggory.WIDTH;
    }
    
}
