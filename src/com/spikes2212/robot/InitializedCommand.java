package com.spikes2212.robot;

public abstract class InitializedCommand extends Command {

	private boolean initialized;

	public InitializedCommand() {
		initialized = false;
	}

	public abstract void initialize();

	public abstract void execute();

	@Override
	public void run() {
		if (!initialized) {
			initialize();
			initialized = true;
		} else {
			execute();
		}
	}

}
