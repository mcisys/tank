package com.mcisys.tank.cor;

import com.mcisys.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {

    private List<Collider> colliderList = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider collider) {
        colliderList.add(collider);
    }

    public boolean collide(GameObject g1, GameObject g2) {
        for (int i = 0; i < colliderList.size(); i++) {
            if (!colliderList.get(i).collide(g1, g2)) {
                return false;
            }
        }
        return true;
    }
}
