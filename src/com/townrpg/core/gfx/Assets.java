package com.townrpg.core.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage grass, sand, dirt, water, gravel, snow, stone, tree;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static void init(){
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
        SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/chars.png"));

        player_down = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];


        player_down[0] = charSheet.crop(1, 0);
        player_down[1] = charSheet.crop(0, 0);
        player_down[2] = charSheet.crop(1, 0);
        player_down[3] = charSheet.crop(2, 0);
        player_left[0] = charSheet.crop(1, 1);
        player_left[1] = charSheet.crop(0, 1);
        player_left[2] = charSheet.crop(1, 1);
        player_left[3] = charSheet.crop(2, 1);
        player_right[0] = charSheet.crop(1, 2);
        player_right[1] = charSheet.crop(0, 2);
        player_right[2] = charSheet.crop(1, 2);
        player_right[3] = charSheet.crop(2, 2);
        player_up[0] = charSheet.crop(1, 3);
        player_up[1] = charSheet.crop(0, 3);
        player_up[2] = charSheet.crop(1, 3);
        player_up[3] = charSheet.crop(2, 3);

        grass = tileSheet.crop(0, 0);
        sand = tileSheet.crop(1, 0);
        dirt = tileSheet.crop(2, 0);
        water = tileSheet.crop(3, 0);
        gravel = tileSheet.crop(4, 0);
        snow = tileSheet.crop(5, 0);
        stone = tileSheet.crop(6, 0);
        tree = tileSheet.crop(0, 1);
    }

}