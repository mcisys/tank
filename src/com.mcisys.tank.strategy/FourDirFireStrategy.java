package com.mcisys.tank.strategy;

import com.mcisys.tank.Bullet;
import com.mcisys.tank.Dir;
import com.mcisys.tank.Tank;

public class FourDirFireStrategy implements FireStrategy {

    private static final FourDirFireStrategy instance = new FourDirFireStrategy();

    private FourDirFireStrategy() {
    }

    public static FourDirFireStrategy getInstance() {
        return instance;
    }

    @Override
    public void fire(Tank t) {
        int bx = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bx, by, dir, t.getGm(), t.getGroup());
        }
    }
}
