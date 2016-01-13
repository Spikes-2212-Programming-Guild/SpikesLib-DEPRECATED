package com.spikes2212.controller;

import edu.wpi.first.wpilibj.Counter;

public class CountedController extends MonitoredController {

	private Counter counter;

	public CountedController(MotorController controller, Counter counter) {
		super(controller);
		this.counter = counter;
	}

	@Override
	public double getDistance() {
		return counter.getDistance();
	}

	@Override
	public double getSpeed() {
		return counter.getRate();
	}

	public void setDistancePerPulse(double distancePerPulse) {
		counter.setDistancePerPulse(distancePerPulse);
	}

	@Override
	public void reset() {
		counter.reset();
	}

}
