package com.spikes2212;

public abstract class Subsystem {

	private Command command;

	public void require(Command command) {
		this.command = command;
	}

	public boolean isRequired() {
		return command != null;
	}

	public Command getCurrentCommand() {
		return command;
	}

}
