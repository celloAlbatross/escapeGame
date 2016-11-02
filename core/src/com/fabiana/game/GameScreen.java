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
import java.awt.RenderingHints.Key;


public class GameScreen extends ScreenAdapter{
    private EscapeGame escapeGame;
    private Texture characterImg;
    private MainCharacter mainCharacter;
    private World world;
    private WorldRenderer worldRenderer;
    
    public GameScreen(EscapeGame escapeGame){
        this.escapeGame = escapeGame;  
       
        world = new World(escapeGame);
        worldRenderer = new WorldRenderer(escapeGame,world);
        characterImg = new Texture("25%_main_character.png");
        
        mainCharacter = world.getMainCharacter();
    }

    public void update(float delta){
        //mainCharacter = world.getMainCharacter();
        
        updateMainCharacterDirection();
               
        world.update(delta);
    }
    
    private void updateMainCharacterDirection(){
        if(Gdx.input.isKeyPressed(Keys.ANY_KEY)){
            if(Gdx.input.isKeyPressed(Keys.LEFT)){
              mainCharacter.setNextDirection(mainCharacter.DIRECTION_LEFT);          
            }
            if(Gdx.input.isKeyPressed(Keys.RIGHT)){
              mainCharacter.setNextDirection(mainCharacter.DIRECTION_RIGHT);
            }
            if(Gdx.input.isKeyPressed(Keys.DOWN)){
              mainCharacter.setNextDirection(mainCharacter.DIRECTION_DOWN);
            }
            if(Gdx.input.isKeyPressed(Keys.UP)){
              mainCharacter.setNextDirection(mainCharacter.DIRECTION_UP);
            }
//            WorldRenderer.count = 2;
        }else{
                mainCharacter.setNextDirection(mainCharacter.DIRECTION_STILL);
//                WorldRenderer.count = 1;
        }
            
    }

    @Override
    public void render(float delta){
        
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update(delta);
      
        worldRenderer.render(delta);
    }
    
}




