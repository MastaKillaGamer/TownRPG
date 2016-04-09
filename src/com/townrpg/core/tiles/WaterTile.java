package com.townrpg.core.tiles;

import com.townrpg.core.gfx.Assets;

public class WaterTile extends Tile {

    public WaterTile(int id) {
        super(Assets.water, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }


}