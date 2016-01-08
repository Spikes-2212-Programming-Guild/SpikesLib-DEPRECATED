package com.spikes2212.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.wpi.first.wpilibj.SpeedController;

public class WrapController implements MotorController {

	private SpeedController[] controllers;

	public <T extends SpeedController> WrapController(Class<T> type, int... channels) {
		Constructor<T> constructor;
		try {
			constructor = type.getConstructor(int.class);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		controllers = new SpeedController[channels.length];
		for (int i = 0; i < channels.length; i++) {
			try {
				controllers[i] = constructor.newInstance(channels[i]);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void set(double speed) {
		for (SpeedController s : controllers) {
			s.set(speed);
		}
	}

}
