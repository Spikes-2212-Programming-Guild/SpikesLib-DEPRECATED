/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.events.logic;

import eventbased.events.Event;

/**
 *
 * @author thinkredstone
 * 
 * An event to check if 
 */
public class NotEvent implements Event {

    private Event e;

    public NotEvent(Event e) {
        this.e = e;
    }

    @Override
    public boolean isHappening() {
        return !e.isHappening();
    }

}
