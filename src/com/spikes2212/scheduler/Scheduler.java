package com.spikes2212.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.spikes2212.robot.Command;

public class Scheduler implements Runnable {

	private List<Command> commands;

	public Scheduler() {
		this.commands = new ArrayList<>();
	}

	public void start(Command command) {
		commands.add(command);
	}

	@Override
	public void run() {
		Iterator<Command> iter = commands.iterator();
		for (Command c = iter.next(); iter.hasNext();) {
			if (c.isFinished()) {
				iter.remove();
			} else {
				c.run();
			}
		}
	}

}
