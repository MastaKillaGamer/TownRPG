package com.townrpg.core.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    private static final int width2 = 48, height2 = 48;

    public static BufferedImage player, enemy, grass, sand, dirt, water, gravel, snow, stone, tree;

    public static void init(){
        //// FIXME: 3/29/2016 
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Sprites.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/Sprites2.png"));

        player = sheet2.crop2(1, 2, width2, height2);
        enemy = sheet2.crop2(4, 1, width2, height2);
        grass = sheet.crop(0, 0, width, height);
        sand = sheet.crop(1, 0, width, height);
        dirt = sheet.crop(2, 0, width, height);
        water = sheet.crop(3, 0, width, height);
        gravel = sheet.crop(4, 0, width, height);
        snow = sheet.crop(5, 0, width, height);
        stone = sheet.crop(6, 0, width, height);
        tree = sheet.crop(0, 1, width, height * 2);
    }

}
