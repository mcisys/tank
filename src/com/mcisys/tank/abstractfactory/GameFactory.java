package com.mcisys.tank.abstractfactory;

import com.mcisys.tank.Dir;
import com.mcisys.tank.Group;
import com.mcisys.tank.TankFrame;

public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, TankFrame tf, Group group);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
