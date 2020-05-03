package com.mcisys.tank.abstractfactory;

import com.mcisys.tank.ResourceMgr;
import com.mcisys.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    private TankFrame tf;

    private boolean living = true;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;

//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= 8) {
            tf.explodeList.remove(this);
        }

        g.setColor(color);
    }
}
