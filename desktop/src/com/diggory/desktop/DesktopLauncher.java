package com.diggory.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.diggory.Diggory;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Diggory";
                config.width = Diggory.WIDTH;
                config.height = Diggory.HEIGHT;
                config.addIcon("icon128.png", Files.FileType.Internal);
                config.addIcon("icon32.png", Files.FileType.Internal);
                config.addIcon("icon16.png", Files.FileType.Internal);
		new LwjglApplication(new Diggory(), config);
	}
}
