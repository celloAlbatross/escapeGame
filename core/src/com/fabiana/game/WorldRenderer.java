package com.fabiana.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import javafx.scene.text.Text;


public class WorldRenderer {
    

    private GameWorld gameWorld;
    private EscapeGame escapeGame;
    
    private Texture characterImg;
    private Texture characterImg1;
    private Texture backGround;
    private Texture rockImg;
    
    private MainCharacter mainCharacter;
    private Rock[] rock;
    private SpriteBatch batch;
    
    private OrthographicCamera camera;
    
    
    static public int count = 0;
    static private int mapSpeed = 0;
   
    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    
    public WorldRenderer(EscapeGame escapeGame, GameWorld gameWorld){
        this.escapeGame = escapeGame;
        batch = escapeGame.batch;
        
        this.gameWorld = gameWorld;

        setPicture();
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, escapeGame.WIDTH/GameWorld.PPM, 
                            escapeGame.HEIGHT/GameWorld.PPM);
        
        mainCharacter = gameWorld.getMainCharacter();
        rock = gameWorld.getRock();
    }
    
    public void render(float delta){
        
        batch.begin();
        
        if(mapSpeed > -1110){
            mapSpeed -= 2;
        }
        batch.draw(backGround, mapSpeed, -200);
        flyRenderer();
        rockRenderer();
        batch.end();
        
        debugRenderer.render(gameWorld.world,camera.combined);
        
        
    }
    
    public void flyRenderer(){
        count++;
        if(count > 30){
            count = 0;
        }
        //batch.draw(Rock, 100, 100, 100, 100);
        Vector2 pos = mainCharacter.body.getPosition();
        if(count < 15){
            batch.draw(characterImg, 
                       pos.x * GameWorld.PPM - characterImg.getWidth() / 2, 
                       pos.y * GameWorld.PPM - characterImg.getHeight() / 2);
            
        }else{
            batch.draw(characterImg1, 
                       pos.x * GameWorld.PPM - characterImg1.getWidth() / 2, 
                       pos.y * GameWorld.PPM - characterImg1.getHeight() / 2);
            
        }
    }
    
    public void setPicture(){
        characterImg = new Texture("25%_main_character.png");
        characterImg1 = new Texture("main_character_1.png");
        backGround = new Texture("BADLAND-day.jpg");
        rockImg = new Texture("Rock.png");
    }
    
    public void rockRenderer(){
        for (int i = 0; i < Rock.numRock; i++) {
            Vector2 pos = rock[i].body.getPosition();
            batch.draw(rockImg, 
                   pos.x * GameWorld.PPM - rockImg.getWidth() / 2, 
                   pos.y * GameWorld.PPM - rockImg.getHeight() / 2);
            
        }
        

    }
}
