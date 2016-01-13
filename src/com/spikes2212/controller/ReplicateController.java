package com.spikes2212.controller;

public class ReplicateController implements MotorController {
	private MotorController controller;

	public ReplicateController(MotorController controller) {
		this.controller = controller;
	}

	@Override
	public void set(double speed) {
		controller.set(speed);
	}
}
