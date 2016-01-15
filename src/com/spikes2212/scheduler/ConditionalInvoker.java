package com.spikes2212.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.spikes2212.predicate.Event;

/*
 * Inspired by Dota 2
 */
public class ConditionalInvoker implements Runnable {

	private Map<Event, Runnable> eventMap;

	public ConditionalInvoker() {
		eventMap = new HashMap<>();
	}

	public void run() {
		for (Entry<Event, Runnable> entry : eventMap.entrySet()) {
			if (entry.getKey().get()) {
				entry.getValue().run();
			}
		}
	}

	public void register(Event event, Runnable runnable) {
		eventMap.put(event, runnable);
	}

}
