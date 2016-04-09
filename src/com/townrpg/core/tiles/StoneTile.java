package com.townrpg.core.tiles;


import com.townrpg.core.gfx.Assets;

public class StoneTile extends Tile {

    public StoneTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}