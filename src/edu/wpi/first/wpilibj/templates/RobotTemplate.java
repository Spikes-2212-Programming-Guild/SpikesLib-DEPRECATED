/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    VictorSP leftR = new VictorSP(0);
    VictorSP leftF = new VictorSP(1);
    VictorSP rightR = new VictorSP(8);
    VictorSP rightF = new VictorSP(9);
    Joystick j = new Joystick(0);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

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
        leftR.set(j.getY());
        leftF.set(j.getY());
        rightR.set(j.getY());
        rightF.set(j.getY());
        SmartDashboard.putNumber("Joystick", j.getY());
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {

    }

}
