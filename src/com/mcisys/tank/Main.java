package com.mcisys.tank;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        int initTankCount = Integer.parseInt(String.valueOf(PropertyMgr.get("initTankCount")));

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tankFrame.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tankFrame, Group.BAD));
        }

        while (true) {
            TimeUnit.MILLISECONDS.sleep(50);
            tankFrame.repaint();
        }
    }
}
