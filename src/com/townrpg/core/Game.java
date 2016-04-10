package com.townrpg.core;

import com.townrpg.core.display.Display;
import com.townrpg.core.gfx.Assets;
import com.townrpg.core.gfx.GameCamera;
import com.townrpg.core.gfx.SpriteSheet;
import com.townrpg.core.inputs.KeyManager;
import com.townrpg.core.states.GameState;
import com.townrpg.core.states.MenuState;
import com.townrpg.core.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    public static SpriteSheet tileSprites, charSprites;
    private int width, height;
    public String title;
    public String tileString;
    private int setfps;
    private Display display;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    //States
    private State gameState;
    private State menuState;
    //Input
    private KeyManager keyManager;
    //Camera
    private GameCamera gameCamera;
    //Handler
    private Handler handler;

    public Game(String title, int width, int height, int setfps) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.setfps = setfps;
        keyManager = new KeyManager();

    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(this, 0, 0);
        handler = new Handler(this);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(gameState);

    }

    private void tick() {
        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw
        if(State.getState() != null)
            State.getState().render(g);

        //Draw End
        bs.show();
        g.dispose();
                }

    public void run(){
            init();

        int fps = setfps;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);

                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
