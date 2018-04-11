package com.company;

import robocode.*;

public class Roboten extends Robot {

    public void run() {
        while(true) {
            ahead(100);
            ahead(-100);
            turnGunLeft(90);
            fire(3);
        }
    }


    public void onHitWall(HitWallEvent e) {

        System.out.print("hihi");

    }

    public void onScannedRobot(ScannedRobotEvent e) {

    }

}
