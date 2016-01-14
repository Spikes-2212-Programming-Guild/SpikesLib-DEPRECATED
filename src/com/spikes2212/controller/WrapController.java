package com.spikes2212.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.wpi.first.wpilibj.SpeedController;

public class WrapController implements MotorController {

	private SpeedController controller;

	public <T extends SpeedController> WrapController(Class<T> type, int channel) {
		Constructor<T> constructor;
		try {
			constructor = type.getConstructor(int.class);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		try {
			controller = constructor.newInstance(channel);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void set(double speed) {
		controller.set(speed);
	}

}
