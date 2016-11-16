/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiana.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.awt.RenderingHints.Key;


public class GameScreen extends ScreenAdapter {
    private EscapeGame escapeGame;
    private Texture characterImg;
    private MainCharacter mainCharacter;
    private GameWorld gameWorld;
    private WorldRenderer worldRenderer;
    
    private Vector2 vel ;
    private Vector2 pos ;

    
    public GameScreen (EscapeGame escapeGame) {
        this.escapeGame = escapeGame;  
       
        gameWorld = new GameWorld(escapeGame);
        worldRenderer = new WorldRenderer(escapeGame,gameWorld);
        characterImg = new Texture("25%_main_character.png");
        
        mainCharacter = gameWorld.getMainCharacter();
        
        vel = mainCharacter.body.getLinearVelocity();
        pos = mainCharacter.body.getPosition();
       
    }

    public void update (float delta) {
        //mainCharacter = world.getMainCharacter();
        
        updateMainCharacterDirection();
               
        gameWorld.update(delta);
    }
    
    private void updateMainCharacterDirection() {
        
            if(Gdx.input.isKeyPressed(Keys.LEFT)){
                mainCharacter.move(mainCharacter.SPEED_LEFT, 0);
            }
            if(Gdx.input.isKeyPressed(Keys.RIGHT)){
                mainCharacter.move(mainCharacter.SPEED_RIGHT, 0);
            }
            if(Gdx.input.isKeyPressed(Keys.DOWN)){
                mainCharacter.move(0, mainCharacter.SPEED_DOWN);
            }
            if(Gdx.input.isKeyPressed(Keys.UP)){
                mainCharacter.move(0, mainCharacter.SPEED_UP);
            }
    }

    @Override
    public void render (float delta) {
        
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update(delta);
            
        worldRenderer.render(delta);
    }
    
}




