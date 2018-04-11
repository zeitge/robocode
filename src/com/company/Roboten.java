package com.company;

import robocode.*;
import java.util.Random;

public class Roboten extends AdvancedRobot {

    int fart = 5;
    int fram = 1000;

    public void run() {
        while(true) {
            fram = fram + 100;
            setTurnRight(10000);
            setMaxVelocity(fart++);
            ahead(fram);
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
        fire(3);
    }

}
