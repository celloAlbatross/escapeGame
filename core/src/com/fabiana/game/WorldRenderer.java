package com.fabiana.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import javafx.scene.text.Text;


public class WorldRenderer {
    

    private GameWorld gameWorld;
    private EscapeGame escapeGame;
    
    private Texture characterImg;
    private Texture characterImg1;
    private Texture backGround;
    private Texture rockImg;
    private Texture gameOver =  new Texture("gameOver.png");
    
    private MainCharacter mainCharacter;
    private Rock[] rock = new Rock[Rock.numRock];
    private SpriteBatch batch;
    private Vector2 pos;
    public Vector2 posMainChar;
    
    
    private OrthographicCamera camera;
    
    private World world;
    
    static public int count = 0;
    static public int rockCounter = 0;
    static private int mapSpeed = 0;
   
    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    
    public WorldRenderer(EscapeGame escapeGame, GameWorld gameWorld){
        this.escapeGame = escapeGame;
        batch = escapeGame.batch;
        
        this.gameWorld = gameWorld;
        
        this.world = gameWorld.world;

        setPicture();
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, escapeGame.WIDTH/GameWorld.PPM, 
                            escapeGame.HEIGHT/GameWorld.PPM);
        
        mainCharacter = gameWorld.getMainCharacter();
        //rock = gameWorld.getRock();
        
        initRock();
    }
    
    public void render(float delta){
        
        batch.begin();
        posMainChar = mainCharacter.body.getPosition();
        if (isGameOver()){
            mapRenderer();
            flyRenderer();
            System.out.println(posMainChar);
            rockRenderer();
            drawRock();
        }else {
            batch.draw(gameOver, 0, 0,EscapeGame.WIDTH,EscapeGame.HEIGHT);
        }
       
        batch.end();
        
        debugRenderer.render(gameWorld.world,camera.combined);
        
        
    }
    
    public void flyRenderer(){
        count++;
        if(count > 30){
            count = 0;
        }
        //batch.draw(Rock, 100, 100, 100, 100);
        posMainChar = mainCharacter.body.getPosition();
        if(count < 15){
            batch.draw(characterImg, 
                       posMainChar.x * GameWorld.PPM - characterImg.getWidth() / 2, 
                       posMainChar.y * GameWorld.PPM - characterImg.getHeight() / 2);
            
        }else{
            batch.draw(characterImg1, 
                       posMainChar.x * GameWorld.PPM - characterImg1.getWidth() / 2, 
                       posMainChar.y * GameWorld.PPM - characterImg1.getHeight() / 2);
            
        }
    }
    
    public void setPicture(){
        characterImg = new Texture("25%_main_character.png");
        characterImg1 = new Texture("main_character_1.png");
        backGround = new Texture("BADLAND-day.jpg");
        rockImg = new Texture("Rock.png");
    }
    
    public void rockRenderer(){      
        genRock();
    }
    
    public void genRock(){
        if (Rock.randomWithRange(1, 100) % 5 == 0 ) {
            for (int i = 0; i < Rock.numRock; i++) {
                rock[i] = new Rock(world);        
            }

        }
    }
    
    public void drawRock(){
        for (int i = 0; i < Rock.numRock; i++) {
            rock[i].draw(batch);
        }
        
    }
    
    public void initRock(){
        for (int i = 0; i < Rock.numRock; i++) {
                rock[i] = new Rock(world);
        }
    }
    
    public void mapRenderer(){
        if (mapSpeed > -1110 ) {
            mapSpeed -= 2;
        }else {
            mapSpeed = 0;
        }
        batch.draw(backGround, mapSpeed, -200);
    }
    
    public boolean isGameOver(){
        if(posMainChar.x < 0 || posMainChar.x>EscapeGame.WIDTH/100 || 
           posMainChar.y < 0 ){
            return false;
        }
        return true;
    }
}
