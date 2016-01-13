package com.spikes2212.robot;

import com.spikes2212.controller.EncodedController;
import com.spikes2212.controller.MonitoredController;
import com.spikes2212.controller.ReverseController;
import com.spikes2212.controller.WrapController;
import com.spikes2212.scheduler.Invoker;
import com.spikes2212.scheduler.Scheduler;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {

	Invoker invoker;
	Scheduler scheduler;
	Shooter shooter;
	Drivetrain drivetrain;

	@Override
	public void robotInit() {
		invoker = new Invoker();
		scheduler = new Scheduler();
		MonitoredController left = new EncodedController(
				new WrapController(Talon.class, RobotMap.PWM.leftFront, RobotMap.PWM.leftRear), new Encoder(1, 2));
		MonitoredController right = new EncodedController(
				new ReverseController(new WrapController(Talon.class, RobotMap.PWM.leftFront, RobotMap.PWM.leftRear)),
				new Encoder(3, 4));
		drivetrain = new Drivetrain(left, right);
	}

	public void teleopPeriodic() {
		invoker.run();
	}

}