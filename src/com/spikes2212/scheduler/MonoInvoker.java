package com.spikes2212.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
 * Inspired by Dota 2
 */
public class MonoInvoker<T> implements Runnable {

	private Map<Supplier<T>, Consumer<T>> map;

	public MonoInvoker() {
		map = new HashMap<>();
	}

	public void run() {
		for (Entry<Supplier<T>, Consumer<T>> entry : map.entrySet()) {
			entry.getValue().accept(entry.getKey().get());
		}
	}

	public void register(Supplier<T> supp, Consumer<T> cons) {
		map.put(supp, cons);
	}

}
