package com.spikes2212.robot;

import com.spikes2212.controller.MotorController;

public class Shooter {
	private MotorController left, right;

	public Shooter(MotorController left, MotorController right) {
		this.left = left;
		this.right = right;
	}

	public void set(double leftSpeed, double rightSpeed) {
		left.set(leftSpeed);
		right.set(rightSpeed);
	}
}
