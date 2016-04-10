package com.townrpg.core.entites.characters;

import com.townrpg.core.Handler;
import com.townrpg.core.gfx.Assets;

import java.awt.*;

public class Player extends Character {

    public Player(Handler handler, float x, float y){
        super(handler, x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);

        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;
    }

    @Override
    public void tick(){
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        g.setColor(Color.MAGENTA);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
    }
}
