package com.spikes2212.controller;

public abstract class PIDController {

	private MotorController controller;

	public PIDController(MotorController controller) {
		this.controller = controller;
	}

	public void set(double speed) {
		controller.set(speed);
	}

	public abstract double getDistance();

	public abstract double getSpeed();

	public abstract void reset();

}
