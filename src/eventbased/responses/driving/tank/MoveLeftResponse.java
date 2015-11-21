/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.responses.driving.tank;

import driving.Tank;
import eventbased.responses.Response;

/**
 *
 * @author thinkredstone
 */
public class MoveLeftResponse extends Response {

    private Tank tank;
    private double speed;

    public MoveLeftResponse(Tank tank, double speed) {
        this.tank = tank;
        this.speed = speed;
    }

    @Override
    protected void respond() {
        //left gets a minus
        tank.setLeft(-speed);
    }

}
