package com.spikes2212.controller;

import edu.wpi.first.wpilibj.Encoder;

public class EncodedController extends PIDController {

	private Encoder encoder;

	public EncodedController(MotorController controller, Encoder encoder) {
		super(controller);
		this.encoder = encoder;
	}

	@Override
	public double getDistance() {
		return encoder.getDistance();
	}

	@Override
	public double getSpeed() {
		return encoder.getRate();
	}

	public void setDistancePerPulse(double distancePerPulse) {
		encoder.setDistancePerPulse(distancePerPulse);
	}

	@Override
	public void reset() {
		encoder.reset();
	}

}
