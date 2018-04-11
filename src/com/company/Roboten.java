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



    public void onBulletHit(BulletHitEvent e) {

    }


    public void onHitByBullet(HitByBulletEvent e) {

    }


    public void onHitRobot(HitRobotEvent e) {

    }


    public void onHitWall(HitWallEvent e) {

    }


    public void onScannedRobot(ScannedRobotEvent e) {

    }

}
