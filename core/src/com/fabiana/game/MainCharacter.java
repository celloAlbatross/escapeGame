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
    
    private World world;
    public Body body;
    
    private Vector2 vel ;
    private Vector2 pos ;
    
    public final float SPEED_RIGHT = 200f;
    public final float SPEED_LEFT = -200f;
    public final float SPEED_UP = 2500f;
    public final float SPEED_DOWN = -0.3f;
    
    public final float MAX_VELOSITY = 0.2f;
    
   
    public MainCharacter(int x,int y,World world){
        
        this.world = world;
        initBody(x, y);
        
        vel = body.getLinearVelocity();
        pos = body.getPosition();
              
    }
     
    public void move(float x ,float y){
        body.applyLinearImpulse(x/GameWorld.PPM, 
                                y/GameWorld.PPM, 
                                pos.x, pos.y, true);
        

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
        fixtureDef.density = 200f; 
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;
        
        Fixture fixture = body.createFixture(fixtureDef);
        circle.dispose();
    }
    
    
}
