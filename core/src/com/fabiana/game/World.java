/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiana.game;

/**
 *
 * @author Fabiana
 */
public class World {
    private MainCharacter mainCharacter;
    private EscapeGame escapeGame;

    public World(EscapeGame escapeGame) {
        this.escapeGame = escapeGame;
        mainCharacter = new MainCharacter(60,60,this);
    }
     
    MainCharacter getMainCharacter(){
        return mainCharacter;
    }
    public void update(float deta){
        mainCharacter.update();
    }
}
