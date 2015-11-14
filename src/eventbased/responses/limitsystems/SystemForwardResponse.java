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
 * response to move a limited system forwards
 */
public class SystemForwardResponse extends Response {

    private final LimitedSystem system;
    private final double speed;

    public SystemForwardResponse(LimitedSystem system, double speed) {
        this.speed = speed;
        this.system = system;
    }

    @Override
    protected void respond() {
        system.forward(speed);
    }

}
