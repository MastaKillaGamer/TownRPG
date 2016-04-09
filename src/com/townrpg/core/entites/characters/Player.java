package com.townrpg.core.entites.characters;

import com.townrpg.core.Game;
import com.townrpg.core.gfx.Assets;

import java.awt.*;

public class Player extends Character {

    private Game game;

    public Player(Game game, float x, float y){
        super(x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick(){
        getInput();
        move();

    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
    }
}
