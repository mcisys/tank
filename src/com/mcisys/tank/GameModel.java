package com.mcisys.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 500, Dir.UP, this, Group.GOOD);
    java.util.List<Bullet> bulletList = new ArrayList<>();
    java.util.List<Tank> tanks = new ArrayList<>();
    List<Explode> explodeList = new ArrayList<>();

    public GameModel() {
        int initTankCount = PropertyMgr.get("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, this, Group.BAD));
        }
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bulletList.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);

        myTank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.get(i).paint(g);
        }

        //碰撞检测
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bulletList.get(i).collideWith(tanks.get(j));
            }
            bulletList.get(i).collideWith(myTank);
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
