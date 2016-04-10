package com.townrpg.core.entites.statics;

import com.townrpg.core.Handler;
import com.townrpg.core.entites.Entity;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

}
