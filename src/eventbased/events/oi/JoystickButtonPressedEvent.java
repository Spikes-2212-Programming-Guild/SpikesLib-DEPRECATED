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
public class JoystickButtonPressedEvent implements Event {

    private Joystick joystick;
    private int ButtonNum;

    public JoystickButtonPressedEvent(Joystick joystick, int ButtonNum) {
        this.joystick = joystick;
        this.ButtonNum = ButtonNum;
    }

    @Override
    public boolean isHappening() {
        return joystick.getRawButton(ButtonNum);
    }

}
