/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2212.robot;

import driving.Tank;
import driving.TankDriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.VictorSP;
import eventbased.Scheduler;
import eventbased.events.oi.JoystickYOverThreshold;
import eventbased.responses.driving.tank.MoveLeftWithJoystickResponse;
import eventbased.responses.driving.tank.MoveRightWithJoystickResponse;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public Scheduler scheduler = new Scheduler();
    public Joystick left = new Joystick(0);
    public Joystick right = new Joystick(1);
    public Tank drivetrain = new TankDriveTrain<VictorSP>(new VictorSP(0), new VictorSP(1), new VictorSP(8), new VictorSP(9));

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        scheduler.addResponse(new JoystickYOverThreshold(left, 0.1), new MoveLeftWithJoystickResponse(drivetrain, left));
        scheduler.addResponse(new JoystickYOverThreshold(right, 0.1), new MoveRightWithJoystickResponse(drivetrain, right));

    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        scheduler.run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {

    }

}
