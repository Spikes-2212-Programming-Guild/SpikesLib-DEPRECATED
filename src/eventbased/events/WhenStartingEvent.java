/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.events;

/**
 *
 * @author thinkredstone
 * 
 * An event to detect when an event is starting
 */
public class WhenStartingEvent implements Event {

    private Event e;
    private boolean notChecked = true;

    public WhenStartingEvent(Event e) {
        this.e = e;
    }

    @Override
    public boolean isHappening() {
        if (!e.isHappening()) {
            notChecked = true;
        }

        if (notChecked) {
            notChecked = false;
            return e.isHappening();
        }
        return false;
    }

}
