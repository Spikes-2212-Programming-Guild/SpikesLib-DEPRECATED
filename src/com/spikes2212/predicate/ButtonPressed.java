package com.spikes2212.predicate;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonPressed extends FirstActive {

	public ButtonPressed(Joystick joystick, int num) {
		super(new ButtonActive(joystick, num));
	}

}
