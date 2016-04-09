package com.townrpg.core.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player, grass, sand, dirt, water, gravel, snow, stone;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player = sheet.crop(0, 0, width, height);
        grass = sheet.crop(0, 0, width, height);
        sand = sheet.crop(width, 0, width, height);
        dirt = sheet.crop(width * 2, 0, width, height);
        water = sheet.crop(width * 3, height, width, height);
        gravel = sheet.crop(width * 4, 0, width, height);
        snow = sheet.crop(width * 5, 0, width, height);
        stone = sheet.crop(width * 6, 0, width, height);
    }

}