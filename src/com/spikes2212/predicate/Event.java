package com.spikes2212.predicate;

public interface Event {
	boolean get();

	public static Event firstActive(Event event) {
		return new FirstActive(event);
	}

	default Event not() {
		return () -> !get();
	}

	default Event and(Event other) {
		return () -> this.get() && other.get();
	}

	default Event or(Event other) {
		return () -> this.get() || other.get();
	}
}
