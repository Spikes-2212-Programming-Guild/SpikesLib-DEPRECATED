package com.spikes2212.controller;

public interface MotorController {

	void set(double speed);

	public static MotorController reverse(MotorController m) {
		return speed -> m.set(-speed);
	}

}
