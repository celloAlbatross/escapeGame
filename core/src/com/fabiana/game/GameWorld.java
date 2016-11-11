/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author Fabiana
 */
public class GameWorld {
    private MainCharacter mainCharacter;
    private EscapeGame escapeGame;
    
    public static int SPWAN_AT_X = 60;
    public static int SPWAN_AT_Y = 60;
    
    
    World world = new World(new Vector2(0, -10), true); 
    

    public GameWorld(EscapeGame escapeGame) {
        this.escapeGame = escapeGame;
        mainCharacter = new MainCharacter(SPWAN_AT_X,SPWAN_AT_Y,this);
    }
     
    MainCharacter getMainCharacter(){
        return mainCharacter;
    }
    
    public void update(float deta){
        mainCharacter.moveUpdate();
    }
}
