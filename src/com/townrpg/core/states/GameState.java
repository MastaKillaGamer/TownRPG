package com.townrpg.core.states;

import java.awt.Graphics;
import java.nio.file.Watchable;

import com.townrpg.core.Game;
import com.townrpg.core.Handler;
import com.townrpg.core.entites.characters.Player;
import com.townrpg.core.worlds.World;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/saves/save1.save");
        handler.setWorld(world);
        player = new Player(handler, world.getSpawnX() * 32, world.getSpawnY() * 32);

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
