package com.spikes2212.predicate;

public class FirstActive implements Event {

	private Event event;
	private boolean prevActive;

	public FirstActive(Event event) {
		this.event = event;
		prevActive = false;
	}

	@Override
	public boolean get() {
		boolean active = event.get();
		boolean returnValue = !prevActive && active;
		prevActive = active;
		return returnValue;
	}

}
