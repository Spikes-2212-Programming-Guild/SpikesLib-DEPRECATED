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
 * An event to check if an event finished
 */
public class WhenFinishingEvent implements Event {

    private Event e;
    private boolean eIsHappaning = false;

    public WhenFinishingEvent(Event e) {
        this.e = e;
    }

    @Override
    public boolean isHappening() {
        boolean b = e.isHappening();
        if (eIsHappaning && !b) {
            eIsHappaning = b;
            return true;
        }
        eIsHappaning = b;
        return false;
    }

}
