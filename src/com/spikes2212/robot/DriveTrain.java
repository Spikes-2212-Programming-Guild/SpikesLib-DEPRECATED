package com.spikes2212.robot;

import com.spikes2212.controller.PIDController;
import com.spikes2212.drive.PIDDrive;
import com.spikes2212.drive.TankDrive;

public class DriveTrain implements TankDrive, PIDDrive {

    private PIDController left, right;

    public DriveTrain(PIDController left, PIDController right) {
        this.left = left;
        this.right = right;

    }

    @Override
    public void tankSet(double leftSpeed, double rightSpeed) {
        left.set(leftSpeed);
        right.set(rightSpeed);
    }

    @Override
    public void pidSet(double speed) {
        tankSet(speed, speed);
    }

    @Override
    public double get() {
        return (left.getDistance() + right.getDistance()) / 2;
    }

}
