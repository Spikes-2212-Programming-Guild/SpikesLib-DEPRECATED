package com.spikes2212.predicate;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonActive implements Event {

	private Joystick joystick;
	private int num;

	public ButtonActive(Joystick joystick, int num) {
		this.joystick = joystick;
		this.num = num;
	}

	@Override
	public boolean get() {
		return joystick.getRawButton(num);
	}

}
