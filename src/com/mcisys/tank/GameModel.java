package com.mcisys.tank;

import com.mcisys.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;

    ColliderChain colliderChain = new ColliderChain();

    private List<GameObject> gameObjects = new ArrayList<>();

    private GameModel() {
    }

    public void init() {
        myTank = new Tank(200, 500, Dir.UP, Group.GOOD);

        int initTankCount = PropertyMgr.get("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }

        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 300));
        add(new Wall(550, 300, 50, 300));
    }

    public static GameModel getInstance() {
        return INSTANCE;
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
