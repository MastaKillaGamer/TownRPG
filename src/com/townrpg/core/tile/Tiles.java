package com.townrpg.core.tile;

import com.townrpg.core.Game;
import com.townrpg.core.gfx.SpriteSheet;

public class Tiles {
        private final int id;
        private final String name;
        private final boolean isSolid, isTrigger;
        private static SpriteSheet sprites = Game.tileSprites;

        public Tiles(int id, String name, boolean isSolid) {
            this.id = id;
            this.name = name;
            this.isSolid = isSolid;
            this.isTrigger = false;
        }

        public boolean isSolid() {
            return isSolid;
        }

        public boolean isTrigger() {
            return isTrigger;
        }

        public int getId() {
            return id;
        }

        public static Tiles getTileById(int id) {
            if (id == 0) return tileGrass;
            if (id == 1) return tileSand;
            if (id == 2) return tileDirt;
            if (id == 3) return tileWater;
            if (id == 4) return tileGravel;
            if (id == 5) return tileSnow;
            if (id == 6) return tileStone;
            if (id == 7) return tileTree;
            else return tileGrass;
        }

        public static SpriteSheet getSprites() {
            return sprites;
        }

        public String getName() {
            return name;
        }

        private static final Tiles tileGrass = new Tiles(0, "Grass", true);
        private static final Tiles tileSand = new Tiles(1, "Sand", false);
        private static final Tiles tileDirt = new Tiles(2, "Dirt", false);
        private static final Tiles tileWater = new Tiles(3, "Water", true);
        private static final Tiles tileGravel = new Tiles(4, "Gravel", false);
        private static final Tiles tileSnow = new Tiles(5, "Snow", false);
        private static final Tiles tileStone = new Tiles(6, "Stone", true);
        private static final Tiles tileTree = new Tiles(7, "Tree", true);

}
