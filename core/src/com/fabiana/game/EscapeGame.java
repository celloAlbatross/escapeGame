package com.fabiana.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class EscapeGame extends Game {
    
    public static final int HEIGHT = 400;
    public static final int WIDTH = 800;
    
    public SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}