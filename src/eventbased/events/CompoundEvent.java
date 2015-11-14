/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.events;

/**
 *
 * @author thinkredstone
 * An event to check if two events are happening at the same time
 */
public class CompoundEvent implements Event {

    private Event a, b;

    public CompoundEvent(Event a, Event b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean isHappening() {
        return a.isHappening() && b.isHappening();
    }

}
