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
    private Texture Rock;
    
    private MainCharacter mainCharacter;
    private SpriteBatch batch;
    
    private OrthographicCamera camera;
    
    
    static public int count = 0;
    static private int mapSpeed = 0;
   
    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    
    public WorldRenderer(EscapeGame escapeGame, GameWorld gameWorld){
        this.escapeGame = escapeGame;
        batch = escapeGame.batch;
        
        this.gameWorld = gameWorld;

        characterImg = new Texture("25%_main_character.png");
        characterImg1 = new Texture("main_character_1.png");
        backGround = new Texture("BADLAND-day.jpg");
        //Rock = new Texture("Rock.png");
        
        mainCharacter = gameWorld.getMainCharacter();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, escapeGame.WIDTH, escapeGame.HEIGHT);
    }
    
    public void render(float delta){
        
        batch.begin();
        
        if(mapSpeed > -1110){
            mapSpeed -= 1;
        }
        batch.draw(backGround, mapSpeed, -200);
        flyRenderer();
        batch.end();
        
        debugRenderer.render(gameWorld.world,camera.combined);
        
    }
    
    public void flyRenderer(){
        count++;
        if(count > 30){
            count = 0;
        }
        //batch.draw(Rock, 100, 100, 100, 100);
        Vector2 pos = gameWorld.getMainCharacter().getPosition();
        if(count < 15){
            batch.draw(characterImg, pos.x, pos.y);
            
        }else{
            batch.draw(characterImg1, pos.x, pos.y);
            
        }
    }
}
