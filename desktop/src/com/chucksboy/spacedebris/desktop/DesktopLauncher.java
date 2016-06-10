package com.chucksboy.spacedebris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.chucksboy.spacedebris.SpaceDebrisMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
		config.height = 800;
		config.title = "Test Title";
		new LwjglApplication(new SpaceDebrisMain(), config);
	}
}
