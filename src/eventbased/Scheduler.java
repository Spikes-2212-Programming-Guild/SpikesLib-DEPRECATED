/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased;

import eventbased.events.Event;
import eventbased.responses.Response;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thinkredstone
 */
public class Scheduler implements Runnable {

    //The map contain the threads that are built around the events
    private Map<Event, Thread> threads;

    public Scheduler() {
        threads = new HashMap<>();
    }

    public void addResponse(Event e, Response r) {
        threads.put(e, new Thread(r));
    }

    @Override
    public void run() {
        for (Map.Entry<Event, Thread> entry : threads.entrySet()) {
            if (entry.getKey().isHappening()) {
                entry.getValue().start();
            }
        }
    }

}
