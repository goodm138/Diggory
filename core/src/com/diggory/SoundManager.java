/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 *
 * @author Scott Goodman
 */
public class SoundManager {
    
    public static Sound HIT = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));
    public static Sound DEATH = Gdx.audio.newSound(Gdx.files.internal("death.wav"));
    public static Sound WON = Gdx.audio.newSound(Gdx.files.internal("won.wav"));
    public static Sound TITLE_MUSIC = Gdx.audio.newSound(Gdx.files.internal("title.mp3"));
    public static Sound GAME_MUSIC = Gdx.audio.newSound(Gdx.files.internal("game.mp3"));
    public static Sound WIN_MUSIC = Gdx.audio.newSound(Gdx.files.internal("winmusic.mp3"));
    public static Sound LOSE_MUSIC = Gdx.audio.newSound(Gdx.files.internal("losemusic.mp3"));
    public static Sound PEW = Gdx.audio.newSound(Gdx.files.internal("pew.wav"));
    public static Sound SECRET_MUSIC = Gdx.audio.newSound(Gdx.files.internal("secretmusic.mp3"));
    public static Sound SECRET = Gdx.audio.newSound(Gdx.files.internal("secret.wav"));
    public static Sound FANFARE = Gdx.audio.newSound(Gdx.files.internal("fanfare.mp3"));
    
}
