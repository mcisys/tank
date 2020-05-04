package com.mcisys.tank.cor;

import com.mcisys.tank.GameObject;
import com.mcisys.tank.Tank;
import com.mcisys.tank.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Wall && o2 instanceof Tank) {
            Wall wall = (Wall) o1;
            Tank tank = (Tank) o2;
            if (wall.rect.intersects(tank.getRect())) {
                tank.goBack();
            }
        } else if (o1 instanceof Tank && o2 instanceof Wall) {
            return collide(o2, o1);
        }
        return true;
    }
}
