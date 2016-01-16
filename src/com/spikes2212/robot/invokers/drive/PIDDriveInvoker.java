/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.robot.invokers.drive;

import com.spikes2212.drive.PIDDrive;
import com.spikes2212.pid.PIDCalculator;

/**
 *
 * @author thinkredstone
 */
public class PIDDriveInvoker implements Runnable {

    private PIDDrive drivetrain;
    private PIDCalculator calculator;
    private double setpoint;
    private boolean firstRun = true;

    public PIDDriveInvoker(PIDDrive drivetrain, PIDCalculator calculator) {
        this.drivetrain = drivetrain;
        this.calculator = calculator;
    }

    @Override
    public void run() {
        if (firstRun) {
            calculator.setSetpoint(setpoint);
            firstRun = false;
        }
        drivetrain.pidSet(calculator.calculate(drivetrain.get()));
        if (calculator.hasReached()) {//TODO: find a way to properly reset the PIDCalculator
            firstRun = true;
        }
    }

}
