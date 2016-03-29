package com.townrpg.core.states;

import com.townrpg.core.Game;

import java.awt.Graphics;


public abstract class State {

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    //Class
    protected Game game;

    public State(Game game){
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
