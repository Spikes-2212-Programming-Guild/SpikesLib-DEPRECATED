package com.spikes2212.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/*
 * Inspired by Dota 2
 */
public class BiInvoker<T, U> implements Runnable {

	private Map<Tuple<Supplier<T>, Supplier<U>>, BiConsumer<T, U>> map;

	public BiInvoker() {
		map = new HashMap<>();
	}

	@Override
	public void run() {
		for (Entry<Tuple<Supplier<T>, Supplier<U>>, BiConsumer<T, U>> entry : map.entrySet()) {
			Tuple<Supplier<T>, Supplier<U>> supp = entry.getKey();
			entry.getValue().accept(supp.getFirst().get(), supp.getSecond().get());
		}
	}

	public void register(Supplier<T> leftSupplier, Supplier<U> rightSupplier, BiConsumer<T, U> consumer) {
		map.put(new Tuple<>(leftSupplier, rightSupplier), consumer);
	}

}
