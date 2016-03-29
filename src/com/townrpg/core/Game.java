package com.townrpg.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import com.townrpg.core.display.Display;
import com.townrpg.core.gfx.Assets;
import com.townrpg.core.inputs.KeyManager;
import com.townrpg.core.states.GameState;
import com.townrpg.core.states.MenuState;
import com.townrpg.core.states.State;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    private int j;
    private int k;
    private int h;
    private int l;
    private boolean moob = true;
    private boolean job = false;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();

    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);

    }

    int x = 0;
    int y = 0;

    private void tick() {
        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();
        if(moob)
            x+=1;

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

        boolean artdraw = true;
        while(artdraw){
            k=l*32;
            j=h*32;
            g.drawImage(Assets.sand,k,j, null);
            if(l==40){
                h++;
                l=-1;
            }
            l++;
            if(h==23){
                h=0;
                artdraw =false;
            }
        }
        g.drawImage(Assets.player, x, y, null);
        if(x == 1280 - 48 && !job){
            y++;
            moob = false;
        }
        if(y == 720 - 48){
            x--;
            job = true;
        }
        if(x == 0 && !moob){
            y--;
        }
        if(y == 0 && x == 0 && !moob)
            moob = true;
            job = false;
        //Draw End
        bs.show();
        g.dispose();
                }

    public void run(){
        init();

        int fps = 60;
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

/*
*/