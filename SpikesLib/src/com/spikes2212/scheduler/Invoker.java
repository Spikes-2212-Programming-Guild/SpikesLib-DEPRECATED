package com.spikes2212.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

import com.spikes2212.predicate.Event;

/*
 * Inspired by Dota 2
 */
public class Invoker {

	private Map<Event, Runnable> eventMap;
	private Map<DoubleSupplier, DoubleConsumer> doubleMap;

	public Invoker() {
		eventMap = new HashMap<>();
		doubleMap = new HashMap<>();
	}

	public void run() {
		for (Entry<Event, Runnable> entry : eventMap.entrySet()) {
			if (entry.getKey().get()) {
				entry.getValue().run();
			}
		}
		for (Entry<DoubleSupplier, DoubleConsumer> entry : doubleMap.entrySet()) {
			entry.getValue().accept(entry.getKey().getAsDouble());
		}
	}

	public void register(Event event, Runnable runnable) {
		eventMap.put(event, runnable);
	}

	public void register(DoubleSupplier supp, DoubleConsumer cons) {
		doubleMap.put(supp, cons);
	}

}
