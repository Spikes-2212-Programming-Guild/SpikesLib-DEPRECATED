package com.spikes2212.controller;

public class ReverseController implements MotorController {
	private MotorController controller;

	public ReverseController(MotorController controller) {
		this.controller = controller;
	}

	@Override
	public void set(double speed) {
		controller.set(-speed);
	}
}
