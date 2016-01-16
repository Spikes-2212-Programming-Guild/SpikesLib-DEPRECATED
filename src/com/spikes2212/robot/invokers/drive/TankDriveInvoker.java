/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.robot.invokers.drive;

import com.spikes2212.drive.TankDrive;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author thinkredstone
 */
public class TankDriveInvoker implements Runnable{
    private Joystick leftJoystick, rightJoystick;
    private TankDrive drivetrain;

    public TankDriveInvoker(Joystick leftJoystick, Joystick rightJoystick, TankDrive drivetrain) {
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        this.drivetrain = drivetrain;
    }

    @Override
    public void run() {
        drivetrain.tankSet(leftJoystick.getY(), rightJoystick.getY());
    }

    
    
}
