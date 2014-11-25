/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Scott Goodman
 */
public class TextureManager {
    
    public static Texture PLAYER = new Texture(Gdx.files.internal("Diggory.png"));
    public static Texture ENEMY = new Texture(Gdx.files.internal("catstench.png"));
    public static Texture ENEMY_RIGHT = new Texture(Gdx.files.internal("catstenchR.png"));
    public static Texture MISSILE_RIGHT = new Texture(Gdx.files.internal("Spike.png"));
    public static Texture MISSILE_LEFT = new Texture(Gdx.files.internal("SpikeL.png"));
    public static Texture MISSILE_UP = new Texture(Gdx.files.internal("SpikeU.png"));
    public static Texture MISSILE_DOWN = new Texture(Gdx.files.internal("SpikeD.png"));
    public static Texture GAMEOVER = new Texture(Gdx.files.internal("GAMEOVER.png"));
    public static Texture WINNER = new Texture(Gdx.files.internal("WINNER.png"));
    public static Texture BACKGROUND = new Texture(Gdx.files.internal("bg.png"));
    public static Texture MENU = new Texture(Gdx.files.internal("menu.png"));
    public static Texture ERROR = new Texture(Gdx.files.internal("error.png"));
    public static Texture TROPHY = new Texture(Gdx.files.internal("trophy.png"));
    
}
