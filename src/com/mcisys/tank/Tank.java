package com.mcisys.tank;

import com.mcisys.tank.strategy.DefaultFireStrategy;
import com.mcisys.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {

    public static final int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD.getHeight();
    private Random random = new Random();

    private int x, y;
    private int oldX, oldY;
    private Dir dir = Dir.DOWN;
    private GameModel gm;
    private Group group = Group.GOOD;

    Rectangle rect = new Rectangle();

    private static final int SPEED = PropertyMgr.get("tankSpeed");

    private boolean moving = true;
    private boolean living = true;

    public Tank(int x, int y, Dir dir, GameModel gm, Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!living) {
            if (this.group == Group.BAD) {
                gm.remove(this);
            }
        }
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        oldX = x;
        oldY = y;
        if (!moving) return;
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) this.fire(DefaultFireStrategy.getInstance());
        if (this.group == Group.BAD && random.nextInt(100) > 95) randomDir();

        boundsCheck();

        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void goBack() {
        this.x = oldX;
        this.y = oldY;
    }

    public void exchangeDir(Tank tank) {
        Dir tempDir = this.dir;
        this.dir = tank.dir;
        tank.dir = tempDir;
    }
}
