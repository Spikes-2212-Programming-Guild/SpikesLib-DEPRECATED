package com.spikes2212.robot;

import com.spikes2212.controller.MotorController;
import com.spikes2212.drive.ArcadeDrive;
import com.spikes2212.drive.TankDrive;

public class Drivetrain implements Stoppable, TankDrive, ArcadeDrive {
	private MotorController left, right;

	public Drivetrain(MotorController left, MotorController right) {
		this.left = left;
		this.right = right;
	}

	public void stop() {
		left.set(0);
		right.set(0);
	}

	@Override
	public void tank(double leftSpeed, double rightSpeed) {
		left.set(leftSpeed);
		right.set(rightSpeed);
	}

	@Override
	public void arcade(double forwardSpeed, double turnSpeed) {
		double leftSpeed;
		double rightSpeed;
		forwardSpeed = limit(forwardSpeed);
		turnSpeed = limit(turnSpeed);
		if (forwardSpeed > 0.0) {
			if (turnSpeed > 0.0) {
				leftSpeed = forwardSpeed - turnSpeed;
				rightSpeed = Math.max(forwardSpeed, turnSpeed);
			} else {
				leftSpeed = Math.max(forwardSpeed, -turnSpeed);
				rightSpeed = forwardSpeed + turnSpeed;
			}
		} else {
			if (turnSpeed > 0.0) {
				leftSpeed = -Math.max(-forwardSpeed, turnSpeed);
				rightSpeed = forwardSpeed + turnSpeed;
			} else {
				leftSpeed = forwardSpeed - turnSpeed;
				rightSpeed = -Math.max(-forwardSpeed, -turnSpeed);
			}
		}
		tank(leftSpeed, rightSpeed);
	}

	protected static double limit(double num) {
		if (num > 1.0) {
			return 1.0;
		}
		if (num < -1.0) {
			return -1.0;
		}
		return num;
	}

}
