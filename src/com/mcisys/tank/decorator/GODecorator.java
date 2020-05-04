package com.mcisys.tank.decorator;

import com.mcisys.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {

    GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void paint(Graphics g) {
        gameObject.paint(g);
    }
}
