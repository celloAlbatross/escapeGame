/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author Fabiana
 */
public class GameWorld {
    private MainCharacter mainCharacter;
    private EscapeGame escapeGame;
    
    World world = new World(new Vector2(0, -10), true); 
    

    public GameWorld(EscapeGame escapeGame) {
        this.escapeGame = escapeGame;
        mainCharacter = new MainCharacter(60,60,this);
    }
     
    MainCharacter getMainCharacter(){
        return mainCharacter;
    }
    
    public void update(float deta){
        mainCharacter.update();
    }
}
