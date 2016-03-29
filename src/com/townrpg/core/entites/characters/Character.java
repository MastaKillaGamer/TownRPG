package com.townrpg.core.entites.characters;

import com.townrpg.core.entites.Entity;

public abstract class Character extends Entity{

    protected int health;

    public Character(float x, float y){
        super(x, y);
        health = 10;
    }
}
