package com.townrpg.core.states;

import java.awt.Graphics;
import java.nio.file.Watchable;

import com.townrpg.core.Game;
import com.townrpg.core.entites.characters.Player;
import com.townrpg.core.worlds.World;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Game game){
        super(game);
        player = new Player(game, 100, 100);
        world = new World(game, "res/saves/save1.save");

    }

    @Override
    public void tick(){
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g){
        world.render(g);
        player.render(g);
    }

}
