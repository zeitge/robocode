package com.company;

import robocode.*;
import robocode.util.Utils;

public class Roboten extends AdvancedRobot {
    int timesHit = 0;
    int firePower = 3;
    boolean right = true;
    int direction = 100;
    String hitRobotName;


    public void run() {
        setAdjustRadarForRobotTurn(true);
        while(true){
            turnRadarRight(360);
        }
    }

    public void onBulletHit(BulletHitEvent e) {
        timesHit++;

    }

    public void onHitByBullet(HitByBulletEvent e) {
        changePath();
        setAhead(-(Math.random()*1000+1000));
    }

    public void onHitRobot(HitRobotEvent e) {
        changePath();
        setAhead(-(Math.random()*1000+1000));
    }

    private void changePath() {
        setAhead(direction);
        direction = -direction;
    }

    public void onHitWall(HitWallEvent e) {
        changePath();
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        turnGunRight(Utils.normalRelativeAngleDegrees((getHeading() + e.getBearing()) - getGunHeading()));
        setTurnRight(e.getBearing()+90);
        changePath();
        if(e.getDistance()>30) {
            firePower = 1;
        } else if(e.getDistance()<30 && e.getDistance()>10) {
            firePower = 2;
        } else if(e.getDistance()<10) {
            firePower = 3;
        }
        setFire(firePower);
    }

}