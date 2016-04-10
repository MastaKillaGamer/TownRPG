package com.townrpg.core.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y){
        return sheet.getSubimage(x * 32, y * 32, 32, 32);
    }
    public BufferedImage crop2(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }

}