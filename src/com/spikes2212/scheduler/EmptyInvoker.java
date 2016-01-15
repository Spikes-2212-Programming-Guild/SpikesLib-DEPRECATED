package com.spikes2212.scheduler;

import java.util.ArrayList;
import java.util.List;

/*
 * Inspired by Dota 2
 */
public class EmptyInvoker implements Runnable {

	private List<Runnable> list;

	public EmptyInvoker() {
		list = new ArrayList<>();
	}

	public void run() {
		list.forEach(Runnable::run);
	}

	public void register(Runnable runnable) {
		list.add(runnable);
	}

}
