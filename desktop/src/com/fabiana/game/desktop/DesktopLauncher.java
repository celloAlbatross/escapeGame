package com.fabiana.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fabiana.game.EscapeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = EscapeGame.WIDTH;
                config.height = EscapeGame.HEIGHT;
		new LwjglApplication(new EscapeGame(), config);
	}
}
