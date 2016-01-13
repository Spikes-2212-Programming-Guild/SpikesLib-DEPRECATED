package com.spikes2212.robot;

import com.spikes2212.Subsystem;
import com.spikes2212.controller.MonitoredController;
import com.spikes2212.drive.ArcadeDrive;
import com.spikes2212.drive.TankDrive;

public class Drivetrain extends Subsystem implements ArcadeDrive, TankDrive {

	private MonitoredController left, right;

	public Drivetrain(MonitoredController left, MonitoredController right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void arcade(double forwardSpeed, double turnSpeed) {
		double leftSpeed, rightSpeed;

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

	@Override
	public void tank(double leftSpeed, double rightSpeed) {
		left.set(leftSpeed);
		right.set(rightSpeed);
	}

}
