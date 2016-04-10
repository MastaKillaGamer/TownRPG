package com.townrpg.core.entites.statics;

import com.townrpg.core.Handler;
import com.townrpg.core.gfx.Assets;
import com.townrpg.core.tiles.Tile;

import java.awt.Graphics;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}
