package com.mcisys.tank;

import com.mcisys.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 500, Dir.UP, this, Group.GOOD);

    ColliderChain colliderChain = new ColliderChain();

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameModel() {
        int initTankCount = PropertyMgr.get("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80, 200, Dir.DOWN, this, Group.BAD));
        }
    }

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量：" + bulletList.size(), 10, 60);
//        g.drawString("敌人的数量：" + tanks.size(), 10, 80);

        myTank.paint(g);
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        //互相碰撞
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                colliderChain.collide(gameObjects.get(i), gameObjects.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
