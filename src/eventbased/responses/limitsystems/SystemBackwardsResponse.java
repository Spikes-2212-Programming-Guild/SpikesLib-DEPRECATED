/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.responses.limitsystems;

import eventbased.responses.Response;
import limitbased.LimitedSystem;

/**
 *
 * @author thinkredstone
 *
 * response to move a limited system backwards
 */
public class SystemBackwardsResponse extends Response {

    private final LimitedSystem system;
    private final double speed;

    public SystemBackwardsResponse(LimitedSystem system, double speed) {
        this.system = system;
        this.speed = speed;
    }

    @Override
    protected void respond() {
        system.backwards(speed);
    }

}
