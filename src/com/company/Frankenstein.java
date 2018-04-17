package com.company;

import robocode.*;
import robocode.util.Utils;

import java.awt.*;

public class Frankenstein extends AdvancedRobot {
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

    public void onHitByBullet(HitByBulletEvent e) {
        setAhead(-(Math.random()*1000+1000));
    }

    public void onHitWall(HitWallEvent e) {
        setBack(100);
        turnLeft(10);
    }

    public void onBulletHit(BulletHitEvent e) {
        setTurnRight(1);
    }

    public void onHitRobot(HitRobotEvent e) {
        setColors(Color.RED, Color.RED, Color.RED);
        if(e.getBearing() > -90 && e.getBearing() <= 90) {
            setTurnRight(e.getBearing() + 90);
            setBack(100);
        } else {
            setTurnRight(100);
            setAhead(100);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if(getVelocity() < 6) {
            setMaxVelocity(6);
        } else {
            setMaxVelocity(4);
        }

        turnGunRight(Utils.normalRelativeAngleDegrees((getHeading() + e.getBearing()) - getGunHeading()));
        setTurnRight(e.getBearing()+90);
        setFire(3);
    }

    public void onWin (WinEvent e) {
        System.out.println("GG, losers!");
    }

    public void onDeath (DeathEvent e) {
        System.out.println("Hacker!!@");
    }
}
