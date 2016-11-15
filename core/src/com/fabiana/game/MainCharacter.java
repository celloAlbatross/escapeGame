package com.fabiana.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import java.util.LinkedList;
import java.util.List;

public class MainCharacter {
    private Vector2 position;
    
    ;


    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static int SPEED = 3;
    public static int GRAVITY = 1;
    
    
    private int currentDirection;
    private int nextDirection;
    private World world;
    public Body body;
    
    
    
    private static final int [][] DIR_DIFF = new int [][] {
        {0,0},
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
     public MainCharacter(int x,int y,World world){
        position = new Vector2(x,y);
        
        this.world = world;
        initBody(x, y);
              
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        
        
        
        

    }
     
    public void moveUpdate(){
    
        
        currentDirection = nextDirection;
            
        position.x += SPEED * DIR_DIFF[currentDirection][0];
        position.y += SPEED * DIR_DIFF[currentDirection][1];
        position.y -= GRAVITY;
        
        
        
  
        System.out.println(position.y);
    }
  
    

    public Vector2 getPosition(){
        return position;
    }
    
    public void setNextDirection(int dir){
        nextDirection = dir;
    }
    
    public void initBody(int x,int y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DynamicBody;
        bodyDef.position.set(200/GameWorld.PPM, 200/GameWorld.PPM);
        body = world.createBody(bodyDef);

             
        CircleShape circle = new CircleShape();
        circle.setRadius(30f/GameWorld.PPM);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.5f; 
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;
        
        Fixture fixture = body.createFixture(fixtureDef);
        circle.dispose();
    }
    
    
}
