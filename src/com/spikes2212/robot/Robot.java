package com.spikes2212.robot;

import com.spikes2212.controller.EncodedController;
import com.spikes2212.controller.WrapController;
import com.spikes2212.pid.PIDCalculator;
import com.spikes2212.robot.invokers.drive.PIDDriveInvoker;
import com.spikes2212.robot.invokers.drive.TankDriveInvoker;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {

    Joystick left, right;
    DriveTrain driveTrain;
    PIDDriveInvoker pidInvoker;
    TankDriveInvoker tankInvoker;

    @Override
    public void robotInit() {
        driveTrain = new DriveTrain(new EncodedController(new WrapController(Talon.class, 1), new Encoder(1, 1)), new EncodedController(new WrapController(Talon.class, 1), new Encoder(1, 1)));
        pidInvoker = new PIDDriveInvoker(driveTrain, new PIDCalculator(1, 1, 1));
        tankInvoker = new TankDriveInvoker(left, left, driveTrain);
    }

    @Override
    public void teleopPeriodic() {
        //TODO: make a class that matches runnable to event
        if (left.getBumper() && !pidInvoker.hasReached()) {
            pidInvoker.run();
        } else {
            tankInvoker.run();
        }

    }

}
