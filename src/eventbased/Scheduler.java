/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import eventbased.events.Event;
import eventbased.responses.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author thinkredstone
 */
public class Scheduler implements Runnable {

    //The map contain the threads that are built around the events
    private Map<Event, Response> responseMap;
    private ArrayList<Thread> threads;

    public Scheduler() {
        responseMap = new HashMap<>();
        threads = new ArrayList<>();
    }

    public void addResponse(Event e, Response r) {
        responseMap.put(e, r);
    }

    @Override
    public void run() {
        for (Iterator<Thread> iterator = threads.iterator(); iterator.hasNext();) {
            Thread t = iterator.next();
            if (!t.isAlive()) {
                iterator.remove();
            }
        }
        for (Map.Entry<Event, Response> entry : responseMap.entrySet()) {
            SmartDashboard.putBoolean(String.valueOf(entry.getKey().getClass()), entry.getKey().isHappening());
            if (entry.getKey().isHappening()) {
                Thread t = new Thread(entry.getValue());
                threads.add(t);
                t.start();
            }
        }
    }

}
