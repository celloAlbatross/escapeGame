package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

public class GameWorld {
    private MainCharacter mainCharacter;
    private EscapeGame escapeGame;

    public static int SPWAN_AT_X = 60;
    public static int SPWAN_AT_Y = 150;
    
    public static final int PPM = 100;
    
    
    public static World world = new World(new Vector2(0, -5f), true); 
    

    public GameWorld(EscapeGame escapeGame) {
        this.escapeGame = escapeGame;
        mainCharacter = new MainCharacter(SPWAN_AT_X,SPWAN_AT_Y,world);
   
    }
     
    MainCharacter getMainCharacter(){
        return mainCharacter;
    }
    
    public void update(float deta){
        
        world.step(1/60f, 6, 2);
    }
}
