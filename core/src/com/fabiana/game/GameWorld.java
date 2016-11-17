/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

/**
 *
 * @author Fabiana
 */
public class GameWorld {
    private MainCharacter mainCharacter;
    private EscapeGame escapeGame;
    //private ArrayList<Rock> rock = new ArrayList<Rock>();
    private Rock[] rock = new Rock[Rock.numRock];
    //private Rock rockky = new Rock(world);
    
    public static int SPWAN_AT_X = 60;
    public static int SPWAN_AT_Y = 150;
    
    public static final int PPM = 100;
    
    
    public static World world = new World(new Vector2(0, -10f), true); 
    

    public GameWorld(EscapeGame escapeGame) {
        this.escapeGame = escapeGame;
        mainCharacter = new MainCharacter(SPWAN_AT_X,SPWAN_AT_Y,world);
        
        for (int i = 0; i < Rock.numRock; i++) {
            rock[i] = new Rock(world);
        }
        
    }
     
    MainCharacter getMainCharacter(){
        return mainCharacter;
    }
    
    Rock[] getRock(){
        return rock;
    }
    
    public void update(float deta){
        //mainCharacter.moveUpdate();
        world.step(1/60f, 6, 2);
    }
}
