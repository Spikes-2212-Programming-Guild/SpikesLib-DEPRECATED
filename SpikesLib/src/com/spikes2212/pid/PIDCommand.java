package com.spikes2212.pid;

import com.spikes2212.Command;

public abstract class PIDCommand extends Command {

	private PIDCalculator calculator;

	public PIDCommand(double kp, double ki, double kd, double tolerance, double setpoint) {
		calculator = new PIDCalculator(kp, ki, kd);
		calculator.setTolerance(tolerance);
		calculator.setSetpoint(setpoint);
	}

	@Override
	public void execute() {
		writeOutput(calculator.calculate(getInput()));
	}

	protected abstract double getInput();

	protected abstract void writeOutput(double output);

	@Override
	public boolean isFinished() {
		return calculator.hasReached();
	}

}
