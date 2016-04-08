package com.townrpg.core.gfx;

import com.townrpg.core.Game;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage qcrop(String tileString) {
        if (tileString == "Grass") return sheet.getSubimage(0 * 32, 0, 32, 32);
        if (tileString == "Sand") return sheet.getSubimage(32, 0, 32, 32);
        if (tileString == "Dirt") return sheet.getSubimage(2 * 32, 0, 32, 32);
        if (tileString == "Water") return sheet.getSubimage(3 * 32, 0, 32, 32);
        if (tileString == "Gravel") return sheet.getSubimage(4 * 32, 0, 32, 32);
        if (tileString == "Snow") return sheet.getSubimage(5 * 32, 0, 32, 32);
        if (tileString == "Stone") return sheet.getSubimage(6 * 32, 0, 32, 32);
        if (tileString == "Tree") return sheet.getSubimage(0, 32, 32, 64);
            return sheet.getSubimage(0, 0, 32, 32);
    }

    public BufferedImage crop(int x, int y, int w, int h) {
        return sheet.getSubimage(x * 32, y * 32, w, h);
    }
}
