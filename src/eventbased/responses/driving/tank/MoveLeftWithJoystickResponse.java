/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.responses.driving.tank;

import driving.Tank;
import edu.wpi.first.wpilibj.Joystick;
import eventbased.responses.Response;

/**
 *
 * @author thinkredstone
 */
public class MoveLeftWithJoystickResponse extends Response {

    private Tank tank;
    private Joystick joystick;

    public MoveLeftWithJoystickResponse(Tank tank, Joystick joystick) {
        this.tank = tank;
        this.joystick = joystick;
    }

    @Override
    protected void respond() {
        //left gets a minus
        tank.setLeft(-joystick.getY());
    }

}
