package com.spikes2212.robot;

import java.util.ArrayList;
import java.util.List;

import com.spikes2212.scheduler.Tuple;

public class CommandGroup extends Command {

	enum AddType {
		SEQUENCE, PARALLEL
	}

	private List<Tuple<Command, AddType>> commands;
	private int index = 0;

	public CommandGroup() {
		commands = new ArrayList<>();
	}

	@Override
	public boolean isFinished() {
		return index >= commands.size();
	}

	@Override
	public void run() {
		if (isFinished()) {
			index = 0;
		}
		Command c = commands.get(index).getFirst();
		if (c.isFinished()) {
			index++;
		} else {
			c.run();
		}
	}

	public void addSequential(Command command) {
		commands.add(new Tuple<>(command, AddType.SEQUENCE));
	}
}
