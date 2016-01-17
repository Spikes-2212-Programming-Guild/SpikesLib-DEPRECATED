/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.commandbased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author thinkredstone
 */
public class ParallelCommand implements Command {

	private List<Command> commands;
	private boolean firstRun;
	private List<Command> currentlyRunning;

	public ParallelCommand(Command[] commands) {
		this.commands = Arrays.asList(commands);
	}

	@Override
	public boolean isFinished() {
		boolean allFinished = true;
		for (Command c : commands) {
			allFinished = c.isFinished() && allFinished;
		}
		return allFinished;
	}

	@Override
	public void end() {
		firstRun = true;
	}

	@Override
	public void run() {
		if (firstRun) {
			firstRun = false;
			currentlyRunning = new ArrayList<>(commands);
		}
		for (Iterator<Command> it = currentlyRunning.iterator(); it.hasNext();) {
			Command c = it.next();
			if (c.isFinished()) {
				c.end();
				it.remove();
			} else {
				c.run();
			}
		}
	}

}
