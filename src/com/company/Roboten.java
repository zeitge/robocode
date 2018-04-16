package com.company;

import robocode.*;

import java.awt.*;


public class Roboten extends AdvancedRobot {

        int fart = 5;
        int fram = 1000;

        @Override
        public void run() {
            while(true) {
                fram = fram + 100;
                setTurnRight(10000);
                setMaxVelocity(fart++);
                ahead(fram);


            }
        }

        // Herman
        @Override
        public void onBulletHit(BulletHitEvent e) {

        }

        // Aylin
        @Override
        public void onHitByBullet(HitByBulletEvent e) {

        }

        // Pu9sheR
        @Override
        public void onHitRobot(HitRobotEvent e) {

            setColors(Color.RED, Color.RED, Color.RED);

            // finn ut hvor roboten ble truffet
            if (e.getBearing() > -90 && e.getBearing() <= 90) {
                setTurnRight(e.getBearing() + 90);
                setBack(100);

            } else {
                setTurnRight(100);
                setAhead(100);
            }

        }

        // Felles
        @Override
        public void onHitWall(HitWallEvent e) {


        }

        // Nils-Christian
        @Override
        public void onScannedRobot(ScannedRobotEvent e) {

            fire(3);

        }

    }
