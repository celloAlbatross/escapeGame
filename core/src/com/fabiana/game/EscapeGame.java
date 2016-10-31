package com.fabiana.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EscapeGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
        Texture backGround;
        
        public static final int HEIGHT = 400;
        public static final int WIDTH = 800;
        
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("25%_main_character.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 150);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
