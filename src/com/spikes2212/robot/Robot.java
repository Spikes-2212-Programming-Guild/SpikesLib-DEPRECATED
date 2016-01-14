package com.spikes2212.robot;

import com.spikes2212.controller.EncodedController;
import com.spikes2212.controller.MotorController;
import com.spikes2212.controller.WrapController;
import com.spikes2212.pid.PIDCalculator;
import com.spikes2212.predicate.ButtonActive;
import com.spikes2212.predicate.FirstActive;
import com.spikes2212.scheduler.Invoker;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {
	private Invoker invokerInvoker = new Invoker();
	private Invoker pidInvoker = new Invoker();
	private Invoker driveingInvoker = new Invoker();

	@Override
	public void robotInit() {
		ButtonActive bla = new ButtonActive(new Joystick(1), 1);

		EncodedController controller = new EncodedController(new WrapController(Talon.class, 1), new Encoder(1, 2));
		PIDCalculator calculator = new PIDCalculator(1, 1, 1);
		pidInvoker.register(calculator::getResult, controller::set);
		pidInvoker.register(controller::getDistance, calculator::calculate);

		DriveTrain driveTrain = new DriveTrain(new WrapController(Talon.class, 1),
				MotorController.reverse(new WrapController(Talon.class, 1)));
		Joystick l = new Joystick(1);
		Joystick r = new Joystick(2);
		driveingInvoker.register(l::getY, driveTrain::setLeft);
		driveingInvoker.register(r::getY, driveTrain::setRight);

		invokerInvoker.register(() -> true, driveingInvoker);
		invokerInvoker.register(() -> (new FirstActive(bla).get() && !calculator.hasReached()), pidInvoker);

	}

	public void teleopPeriodic() {
		invokerInvoker.run();
	}

}