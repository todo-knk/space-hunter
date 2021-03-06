package com.jfsaaved.libgdxgamejam15.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jfsaaved.libgdxgamejam15.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = Main.WIDTH;
        config.height = Main.HEIGHT;
        config.title = Main.TITLE;
        config.fullscreen = false;
        config.resizable = false;

        new LwjglApplication(new Main(), config);

	}
}
