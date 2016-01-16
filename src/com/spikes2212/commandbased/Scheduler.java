/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.commandbased;

import com.spikes2212.predicate.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thinkredstone
 */
public class Scheduler {

    private Map<Event, Runnable> runnables;
    private List<Runnable> currentlyRunning;

    public Scheduler() {
        runnables = new HashMap<>();
    }

    public void register(Event event, Runnable runnable) {
        runnables.put(event, runnable);
    }

    public void run() {
        for (Map.Entry<Event, Runnable> entry : runnables.entrySet()) {
            if(entry.getKey().get()){
                if(entry.getValue() instanceof Command)
            }
        }
    }
}
