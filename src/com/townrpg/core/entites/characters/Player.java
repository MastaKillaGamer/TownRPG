package com.townrpg.core.entites.characters;

import com.townrpg.core.Handler;
import com.townrpg.core.gfx.Animation;
import com.townrpg.core.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Character {

    //Animations
    private Animation animDown, animUp, animLeft, animRight;

    public Player(Handler handler, float x, float y){
        super(handler, x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);

        //Bounds
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;

        //Animations
        animDown = new Animation(500 /2, Assets.player_down);
        animUp = new Animation(500 / 2, Assets.player_up);
        animLeft = new Animation(500 / 2, Assets.player_left);
        animRight = new Animation(500 / 2, Assets.player_right);
    }

    @Override
    public void tick(){
        //Animations
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        //Movement
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
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        //g.setColor(Color.MAGENTA);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
        //        (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
        //       bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else{
            return animDown.getCurrentFrame();
        }
    }
}
