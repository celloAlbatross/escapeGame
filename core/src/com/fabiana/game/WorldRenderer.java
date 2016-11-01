package com.fabiana.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class WorldRenderer {
    

    private World world;
    private EscapeGame escapeGame;
    private Texture characterImg;
    private MainCharacter mainCharacter;
    private SpriteBatch batch;
   
    
    public WorldRenderer(EscapeGame escapeGame, World world){
        this.escapeGame = escapeGame;
        batch = escapeGame.batch;
        
        this.world = world;

        characterImg = new Texture("25%_main_character.png");
        mainCharacter = world.getMainCharacter();
        
    }
    
    public void render(float delta){
        
        
        batch.begin();
        Vector2 pos = world.getMainCharacter().getPosition();
        batch.draw(characterImg, pos.x, pos.y);
      
        batch.end();
    }
}
