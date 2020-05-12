package com.mcisys.tank.observer;

import com.mcisys.tank.Group;
import com.mcisys.tank.Tank;
import com.mcisys.tank.strategy.DefaultFireStrategy;
import com.mcisys.tank.strategy.FourDirFireStrategy;

public class TankFireHandle implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank tank = e.getSource();
        tank.fire(tank.getGroup() == Group.GOOD ? FourDirFireStrategy.getInstance() : DefaultFireStrategy.getInstance());
    }
}
