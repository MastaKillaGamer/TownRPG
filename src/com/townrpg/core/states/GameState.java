package com.townrpg.core.states;

import java.awt.Graphics;
import java.nio.file.Watchable;

import com.townrpg.core.Game;
import com.townrpg.core.Handler;
import com.townrpg.core.entites.characters.Player;
import com.townrpg.core.worlds.World;

public class GameState extends State {

    private World world;
    private Player player;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/saves/save1.save");
        handler.setWorld(world);

    }

    @Override
    public void tick(){
        world.tick();
    }

    @Override
    public void render(Graphics g){
        world.render(g);
    }

}
