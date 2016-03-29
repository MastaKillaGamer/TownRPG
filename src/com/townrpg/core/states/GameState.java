package com.townrpg.core.states;

import java.awt.Graphics;

import com.townrpg.core.Game;
import com.townrpg.core.entites.characters.Player;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 100, 100);
    }

    @Override
    public void tick(){
        player.tick();
    }

    @Override
    public void render(Graphics g){
        player.render(g);
    }

}
