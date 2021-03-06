/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diggory.screen;

/**
 *
 * @author Scott Goodman
 */
public class ScreenManager {
    
    private static Screen currentScreen;
    
    public static void setScreen(Screen screen){
        if (currentScreen != null) {
            currentScreen.dispose();
        }
        currentScreen = screen;
        currentScreen.create();

    }
    
    public static Screen getCurrentScreen() {
        return currentScreen;
    }
}
