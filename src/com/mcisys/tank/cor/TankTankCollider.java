package com.mcisys.tank.cor;

import com.mcisys.tank.GameObject;
import com.mcisys.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            if (tank1.getRect().intersects(tank2.getRect())) {
                tank1.goBack();
                tank2.goBack();
            }
        }
        return true;
    }
}
