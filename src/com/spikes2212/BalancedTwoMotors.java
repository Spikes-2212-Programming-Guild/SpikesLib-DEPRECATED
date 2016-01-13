package com.spikes2212;

import com.spikes2212.controller.MonitoredController;
import com.spikes2212.pid.PIDCommand;

public abstract class BalancedTwoMotors extends PIDCommand {

	private MonitoredController a, b;

	private double maximumOutput;

	public BalancedTwoMotors(double p, double i, double d, double tolerance, MonitoredController a,
			MonitoredController b) {
		super(p, i, d, tolerance, 0);
		this.a = a;
		this.b = b;
	}

	@Override
	protected double getInput() {
		return a.getSpeed() - b.getSpeed();
	}

	@Override
	protected void writeOutput(double output) {
		maximumOutput = Math.max(maximumOutput, Math.abs(output));
		a.set(getSpeed() - output);
		b.set(getSpeed() + output);
	}

	public abstract double getSpeed();

	@Override
	public void end() {
		a.set(0);
		b.set(0);
	}

}
