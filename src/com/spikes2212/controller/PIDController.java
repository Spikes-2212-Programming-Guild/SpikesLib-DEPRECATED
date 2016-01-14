package com.spikes2212.controller;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

public abstract class PIDController implements MotorController, DoubleSupplier, DoubleConsumer {

	private MotorController controller;

	public PIDController(MotorController controller) {
		this.controller = controller;
	}

	@Override
	public void set(double speed) {
		controller.set(speed);
	}

	@Override
	public double getAsDouble() {
		return getDistance();
	}

	@Override
	public void accept(double value) {
		set(value);
	}

	public abstract double getDistance();

	public abstract double getSpeed();

	public abstract void reset();

}
