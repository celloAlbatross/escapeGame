package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;
import java.util.LinkedList;
import java.util.List;

public class MainCharacter {
    private Vector2 position;

    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    
    private int currentDirection;
    private int nextDirection;
    private World world;
 
    
    
    private static final int [][] DIR_DIFF = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    
     public MainCharacter(int x,int y,World world){
        position = new Vector2(x,y);
        
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        
        this.world = world;
        
    }
     
    public void update(){
    
        
        currentDirection = nextDirection;
            
        position.x += SPEED * DIR_DIFF[currentDirection][0];
        position.y += SPEED * DIR_DIFF[currentDirection][1];
    }
  
    

    public Vector2 getPosition(){
        return position;
    }
    
    public void setNextDirection(int dir){
        nextDirection = dir;
    }
    
    
}
