package com.spikes2212.controller;

public class MultiController implements MotorController {

	private MotorController[] controllers;

	public MultiController(MotorController... controllers) {
		this.controllers = controllers;
	}

	@Override
	public void set(double speed) {
		for (MotorController c : controllers) {
			c.set(speed);
		}
	}

}
