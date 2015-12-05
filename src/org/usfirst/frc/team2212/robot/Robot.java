/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2212.robot;

import components.Gearbox;
import components.ReverseSpeedController;
import driving.Tank;
import driving.TankDriveTrain;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import eventbased.Scheduler;
import eventbased.events.Event;
import eventbased.events.logic.NotEvent;
import eventbased.events.oi.JoystickButtonPressedEvent;
import eventbased.events.oi.JoystickYOverThreshold;
import eventbased.responses.basicsystems.MoveSpeedControllerResponse;
import eventbased.responses.driving.tank.MoveLeftResponse;
import eventbased.responses.driving.tank.MoveLeftWithJoystickResponse;
import eventbased.responses.driving.tank.MoveRightResponse;
import eventbased.responses.driving.tank.MoveRightWithJoystickResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vision.ImageProcessor;

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
    public Tank drivetrain = new TankDriveTrain(new ReverseSpeedController(new Talon(0)), new ReverseSpeedController(new Talon(1)), new Talon(2), new Talon(3));
    public Gearbox loader = new Gearbox(new VictorSP(8), new ReverseSpeedController(new VictorSP(9)));
    public Gearbox shooter = new Gearbox(new CANTalon(1), new ReverseSpeedController(new CANTalon(2)));
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        Event leftThreshold = new JoystickYOverThreshold(left, 0.1);
        Event rightThreshold = new JoystickYOverThreshold(right, 0.1);
        Event loadingButtonPressed = new JoystickButtonPressedEvent(left, 4);
        Event shootingButtonPressed = new JoystickButtonPressedEvent(left, 10);
        scheduler.addResponse(leftThreshold, new MoveLeftWithJoystickResponse(drivetrain, left));
        scheduler.addResponse(rightThreshold, new MoveRightWithJoystickResponse(drivetrain, right));
        scheduler.addResponse(new NotEvent(leftThreshold), new MoveLeftResponse(drivetrain, 0));
        scheduler.addResponse(new NotEvent(rightThreshold), new MoveRightResponse(drivetrain, 0));
        
        scheduler.addResponse(loadingButtonPressed, new MoveSpeedControllerResponse(loader, 0.5));
        scheduler.addResponse(new NotEvent(loadingButtonPressed), new MoveSpeedControllerResponse(loader, 0));
        scheduler.addResponse(shootingButtonPressed, new MoveSpeedControllerResponse(shooter, 0.5));
        scheduler.addResponse(new NotEvent(shootingButtonPressed), new MoveSpeedControllerResponse(shooter, 0));
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
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

    @Override
    public void disabledInit() {
    }

}
