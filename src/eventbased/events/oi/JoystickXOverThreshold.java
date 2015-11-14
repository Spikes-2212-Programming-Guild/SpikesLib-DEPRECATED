/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.events.oi;

import edu.wpi.first.wpilibj.Joystick;
import eventbased.events.Event;

/**
 *
 * @author thinkredstone
 */
public class JoystickXOverThreshold implements Event {

    private Joystick joystick;
    private double threshold;

    public JoystickXOverThreshold(Joystick joystick, double threshold) {
        this.joystick = joystick;
        this.threshold = threshold;
    }

    @Override
    public boolean isHappening() {
        return Math.abs(joystick.getX()) > threshold;
    }

}
