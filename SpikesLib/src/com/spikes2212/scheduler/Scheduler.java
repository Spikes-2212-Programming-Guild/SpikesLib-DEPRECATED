package com.spikes2212.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.spikes2212.Command;
import com.spikes2212.Subsystem;

public class Scheduler {

	private List<Command> commands;

	public Scheduler() {
		commands = new ArrayList<>();
	}

	public void add(Command command) {
		commands.add(command);
	}

	public void run() {
		Iterator<Command> iter = commands.iterator();
		iter.forEachRemaining(c -> {
			for (Subsystem s : c.getRequirements()) {
				if (s.isRequired()) {
					Command curr = s.getCurrentCommand();
					curr.interrupted();
					iter.remove();
				}
				if (c.isFinished()) {
					c.end();
					iter.remove();
				} else {
					c.execute();
				}
			}
		});
	}

}
