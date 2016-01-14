package com.spikes2212.robot;

import com.spikes2212.controller.MotorController;
import com.spikes2212.drive.TankDrive;

public class DriveTrain implements TankDrive {
	private MotorController left, right;

	public DriveTrain(MotorController left, MotorController right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void setLeft(double speed) {
		left.set(speed);

	}

	@Override
	public void setRight(double speed) {
		right.set(speed);

	}

}
