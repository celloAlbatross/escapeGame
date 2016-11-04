package com.fabiana.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import javafx.scene.text.Text;


public class WorldRenderer {
    

    private World world;
    private EscapeGame escapeGame;
    
    private Texture characterImg;
    private Texture characterImg1;
    private Texture backGround;
    private Texture Rock;
    
    private MainCharacter mainCharacter;
    private SpriteBatch batch;
    
    
    static public int count = 0;
    static private int mapSpeed = 0;
   
    
    public WorldRenderer(EscapeGame escapeGame, World world){
        this.escapeGame = escapeGame;
        batch = escapeGame.batch;
        
        this.world = world;

        characterImg = new Texture("25%_main_character.png");
        characterImg1 = new Texture("main_character_1.png");
        backGround = new Texture("BADLAND-day.jpg");
        //Rock = new Texture("Rock.png");
        
        mainCharacter = world.getMainCharacter();
        
    }
    
    public void render(float delta){
        
        batch.begin();
        
        if(mapSpeed > -1110){
            mapSpeed -= 1;
        }
        batch.draw(backGround, mapSpeed, -200);
        count++;
        if(count > 30){
            count = 0;
        }
        //batch.draw(Rock, 100, 100, 100, 100);
        Vector2 pos = world.getMainCharacter().getPosition();
        if(count < 15){
            batch.draw(characterImg, pos.x, pos.y);
            
        }else{
            batch.draw(characterImg1, pos.x, pos.y);
            
        }
        batch.end();
    }
}
