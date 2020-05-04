package com.mcisys.tank.decorator;

import com.mcisys.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    public void paint(Graphics graphics) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        super.paint(graphics);

        Color color = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        graphics.drawRect(gameObject.x, gameObject.y, getWidth(), getHeight());
        graphics.setColor(color);
    }

    public int getWidth() {
        return super.gameObject.getWidth();
    }

    public int getHeight() {
        return super.gameObject.getHeight();
    }
}
