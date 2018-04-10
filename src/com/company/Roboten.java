package com.company;

import robocode.*;

public class Roboten extends Robot {

    @Override
    public void run() {
        while(true) {
            ahead(100);
            ahead(-100);
            turnGunLeft(90);
            fire(3);
        }
    }

    @Override
    public void onBulletHit(BulletHitEvent e) {

    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {

    }

    @Override
    public void onHitRobot(HitRobotEvent e) {

    }

    @Override
    public void onHitWall(HitWallEvent e) {

    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {

    }

}
