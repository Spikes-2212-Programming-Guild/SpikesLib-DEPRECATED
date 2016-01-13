package com.spikes2212.predicate;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class AxisSupplier implements DoubleSupplier {
	private Joystick joystick;
	private AxisType axis;

	public AxisSupplier(Joystick joystick, AxisType axis) {
		this.joystick = joystick;
		this.axis = axis;
	}

	@Override
	public double getAsDouble() {
		return joystick.getAxis(axis);
	}

}
