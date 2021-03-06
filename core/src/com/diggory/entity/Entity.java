/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Scott Goodman
 */
public abstract class Entity {
    
    public Texture texture;
    public Vector2 pos, direction;
    public TextureRegion tex;
    
    public Entity(Texture texture, Vector2 pos, Vector2 direction) {
        this.texture = texture;
        this.pos = pos;
        this.direction = direction;
        tex = new TextureRegion(texture);
    }
    
    public abstract void update();
    
    public void render(SpriteBatch sb) {
        sb.draw(tex, pos.x, pos.y);
    }
    
    public Vector2 getPosition() {
        return pos;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    }
    
    public void setDirection(float x, float y) {
        direction.set(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }
    
}
