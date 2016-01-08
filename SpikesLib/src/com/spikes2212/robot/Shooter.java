package com.spikes2212.robot;

import com.spikes2212.Subsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;

public class Shooter extends Subsystem {

	private CANTalon left, right;

	public Shooter(CANTalon left, CANTalon right) {
		this.left = left;
		this.right = right;
		left.changeControlMode(ControlMode.Voltage);
		right.changeControlMode(ControlMode.Voltage);
		left.enableControl();
		right.enableControl();
	}

	public Shooter(int leftMotorID, int rightMotorID) {
		this(new CANTalon(leftMotorID), new CANTalon(rightMotorID));
	}

	public void shoot(double leftVoltage, double rightVoltage) {
		left.set(leftVoltage);
		right.set(rightVoltage);
	}

	public void stop() {
		left.set(0);
		right.set(0);
	}

}
