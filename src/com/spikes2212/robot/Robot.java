package com.spikes2212.robot;

import com.spikes2212.controller.MotorController;
import com.spikes2212.controller.WrapController;
import com.spikes2212.predicate.ButtonPressed;
import com.spikes2212.scheduler.BiInvoker;
import com.spikes2212.scheduler.ConditionalInvoker;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {

	ConditionalInvoker navInvoker = new ConditionalInvoker();
	BiInvoker<Double, Double> driveInvoker = new BiInvoker<>();
	Drivetrain drivetrain;
	Joystick driverStick = new Joystick(0);
	Joystick navStick = new Joystick(1);

	@Override
	public void robotInit() {
		MotorController left = new WrapController(Talon.class, 0);
		MotorController right = MotorController.reverse(new WrapController(Talon.class, 1));
		drivetrain = new Drivetrain(left, right);
		driveInvoker.register(driverStick::getY, driverStick::getTwist, drivetrain::arcade);
		navInvoker.register(new ButtonPressed(navStick, 0), drivetrain::stop);
	}

	public void teleopPeriodic() {
		navInvoker.run();
		driveInvoker.run();
	}

}