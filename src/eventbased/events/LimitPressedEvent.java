/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.events;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author thinkredstone
 */
public class LimitPressedEvent implements Event{
    DigitalInput limit;

    public LimitPressedEvent(DigitalInput limit) {
        this.limit = limit;
    }

    public LimitPressedEvent(int port) {
        this(new DigitalInput(port));
    }
    
    
    
    @Override
    public boolean isHappening() {
        return limit.get();
    }
    
}
