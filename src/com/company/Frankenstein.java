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
            setMaxVelocity(fart);
            ahead(fram);
        }

    }

    public void onHitByBullet(HitByBulletEvent e) {
        setAhead(-(Math.random() * 1000 + 1000));
        // Når roboten blir truffet av en bullet, vil roboten
        // kjøre tilbake.
    }

    public void onHitWall(HitWallEvent e) {
        setBack(100);
        turnLeft(10);
        //Når den treffer veggen, går den tilbake 100 og snur 10 grader til venstre.
    }

    public void onBulletHit(BulletHitEvent e) {
        setTurnRight(1);
        // Når bulleten treffer en annen robot, juster 1 grader til høyre.
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
        //Når roboten vår kolliderer med en annen robot, blir den illsint og rød.
        //Dersom roboten kolliderer i front, så skal den kjøre tilbake og svinge.
        //Dersom roboten kolliderer bak, så skal den svinge til høyre og kjøre fram,
        //for å komme unna.
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if(getVelocity() < 6) {
            fart = 6;
        } else {
            fart = 4;
        }
        //Veksler mellom fart på 6 og 4.

        turnGunRight(Utils.normalRelativeAngleDegrees((getHeading() + e.getBearing()) - getGunHeading()));
        setTurnRight(e.getBearing()+90);
        setFire(3);
        //Tracker roboten den scanner, og prøver å streife rundt den i en høyresving, samtidig som den skyter.
    }

    public void onWin (WinEvent e) {
        System.out.println("GG, losers!");
        //Skriver ut i konsollen dersom man vinner.
    }

    public void onDeath (DeathEvent e) {
        System.out.println("Hacker!!@");
        //Anklager andre for juks dersom man taper.
    }
}
