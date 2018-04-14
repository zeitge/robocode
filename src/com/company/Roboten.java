package com.company;

import robocode.*;

import java.awt.*;

public class Roboten extends AdvancedRobot {



    @Override
    public void run() {
        setBodyColor(Color.red);
        setGunColor(Color.black);

        while(true) {
            setTurnLeft(10000);
            setMaxVelocity(4);
            setMaxTurnRate(10);
            ahead(10000);

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
// (bare til testing)
        if (e.getBearing() > -10 && e.getBearing() < 10) {
            fire(3);
        }
        if (e.isMyFault()) {
            turnLeft(10);
        }

    }

    @Override
    public void onHitWall(HitWallEvent e) {
// (bare til testing)
        turnLeft(10);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        if (getVelocity() < 6){
            setMaxVelocity(6);
        }
        else{
            setMaxVelocity(4);
        }
        fire(3);
    }
    public void onWin (WinEvent e) {
        System.out.println("GG, losers!");
    }
    public void onDeath (DeathEvent e) {
        System.out.println("Hacker!!@");
    }

}
