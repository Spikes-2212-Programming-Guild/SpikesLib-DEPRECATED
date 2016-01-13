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
public class MoveRightResponse extends Response {

    private Tank tank;
    private double speed;

    public MoveRightResponse(Tank tank, double speed) {
        this.tank = tank;
        this.speed = speed;
    }

    @Override
    protected void respond() {
        tank.setRight(speed);
    }

}
