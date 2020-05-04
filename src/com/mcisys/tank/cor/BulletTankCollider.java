package com.mcisys.tank.cor;

import com.mcisys.tank.Bullet;
import com.mcisys.tank.Explode;
import com.mcisys.tank.GameObject;
import com.mcisys.tank.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if (bullet.getGroup() == tank.getGroup()) return true;
            if (bullet.getRect().intersects(tank.getRect())) {
                tank.die();
                bullet.die();
                int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                new Explode(ex, ey);
                return false;
            }
            return true;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
