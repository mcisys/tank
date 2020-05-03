package com.mcisys.tank.cor;

import com.mcisys.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
