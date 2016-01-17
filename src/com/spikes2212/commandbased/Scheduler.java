/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.commandbased;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.spikes2212.predicate.Event;

/**
 *
 * @author thinkredstone
 */
public class Scheduler {

	private Map<Event, Command> commands;
	private List<Command> currentlyRunning;

	public Scheduler() {
		commands = new HashMap<>();
	}

	public void register(Event event, Runnable runnable) {
		commands.put(event, new Command() {

			@Override
			public void run() {
				runnable.run();
			}

			@Override
			public boolean isFinished() {
				return !event.get();
			}

			@Override
			public void end() {
			}
		});
	}

	public void run() {
		for (Map.Entry<Event, Command> entry : commands.entrySet()) {
			if (entry.getKey().get()
					&& !currentlyRunning.contains(entry.getKey())) {
				currentlyRunning.add(entry.getValue());
			}
		}
		for (Iterator<Command> it = currentlyRunning.iterator(); it.hasNext();) {
			Command command = it.next();
			if (command.isFinished()) {
				command.end();
				it.remove();
				break;
			}
			command.run();
		}
	}
}
