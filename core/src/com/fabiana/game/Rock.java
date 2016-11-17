package com.fabiana.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class Rock {
    
    private World world;
    private OrthographicCamera camera;
    
    public Body body;
    
    public static final int numRock = 1000;
    
    public Rock(World world){
        this.world = world;
                        
        initBody(randomWithRange(10, 800), randomWithRange(1000, 70000));
    }
    
    public void initBody(int x, int y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x/GameWorld.PPM, y/GameWorld.PPM);
        body = world.createBody(bodyDef);

             
        CircleShape circle = new CircleShape();
        circle.setRadius(35f/GameWorld.PPM);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 1f; 
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;
        
        Fixture fixture = body.createFixture(fixtureDef);
        circle.dispose();
    }
    
    int randomWithRange(int min, int max)
    {
       int range = (max - min) + 1;     
       return (int)(Math.random() * range) + min;
    }

}