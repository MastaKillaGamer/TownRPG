package com.townrpg.core.entites.characters;

import com.townrpg.core.Game;
import com.townrpg.core.entites.Entity;

public abstract class Character extends Entity{

    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_CHARACTER_WIDTH = 32, DEFAULT_CHARACTER_HEIGHT = 32;
    public static final float DEFAULT_SPEED = 3.0f;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Character(Game game, float x, float y, int width, int height){
        super(game, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        x += xMove;
        y += yMove;
    }

    //Gets


    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    //Sets


    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
