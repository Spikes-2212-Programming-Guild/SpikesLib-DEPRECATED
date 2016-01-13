package com.spikes2212;

import java.util.Arrays;
import java.util.List;

public abstract class Command {

	private List<Subsystem> subsystems;

	public Command(Subsystem... subsystems) {
		this.subsystems = Arrays.asList(subsystems);
	}

	public List<Subsystem> getRequirements() {
		return subsystems;
	}

	public abstract void execute();

	public abstract void end();

	public abstract boolean isFinished();

	public void interrupted() {
		end();
	}

}
