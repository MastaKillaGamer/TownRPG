package com.townrpg.core.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player, grass, sand, dirt, water, gravel, snow, stone;

    public static void init(){
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
        SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/chars.png"));
        
        player = charSheet.crop(0, 0, width, height);
        grass = tileSheet.crop(0, 0, width, height);
        sand = tileSheet.crop(width, 0, width, height);
        dirt = tileSheet.crop(width * 2, 0, width, height);
        water = tileSheet.crop(width * 3, height, width, height);
        gravel = tileSheet.crop(width * 4, 0, width, height);
        snow = tileSheet.crop(width * 5, 0, width, height);
        stone = tileSheet.crop(width * 6, 0, width, height);
    }

}