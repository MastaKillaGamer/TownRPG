package com.townrpg.core.entites;

import com.townrpg.core.Handler;
import com.townrpg.core.entites.characters.Player;
import com.townrpg.core.worlds.World;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private Player player;
    private Handler handler;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
    }

    public void tick(){
        for(int i = 0;i < entities.size();i++){
            Entity e = entities.get(i);
            e.tick();
        }
        player.tick();
    }

    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
        player.render(g);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTERS SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}
