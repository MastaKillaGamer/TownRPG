package com.townrpg.core;

import com.townrpg.core.display.Display;
import com.townrpg.core.gfx.ImageLoader;
import com.townrpg.core.gfx.SpriteSheet;
import com.townrpg.core.inputs.KeyManager;
import com.townrpg.core.states.GameState;
import com.townrpg.core.states.MenuState;
import com.townrpg.core.states.State;
import com.townrpg.core.tile.Tiles;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    public static SpriteSheet tileSprites, charSprites;
    public int width, height;
    public String title;
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
        ImageLoader loader = new ImageLoader();
        BufferedImage tileSheet = loader.load("textures/tiles.png");
        BufferedImage charSheet = loader.load("textures/chars.png");
        tileSprites = new SpriteSheet(tileSheet);
        charSprites = new SpriteSheet(charSheet);
        gameState = new GameState(this);
        menuState = new MenuState(this);
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

        g.drawImage(Tiles.getSprites().crop(0, 0, 32, 32), 0, 0, 32, 32, null);


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
