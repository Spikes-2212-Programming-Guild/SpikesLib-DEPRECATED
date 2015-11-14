/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author thinkredstone
 * @param <SC> The type of speed controller
 *
 * A way to reverse a Speed controller. Will cause the speed controller to
 * return opposite get and set opposite speed.
 */
public class ReverseSpeedController<SC extends SpeedController> implements SpeedController {

    SC sc;

    public ReverseSpeedController(SC sc) {
        this.sc = sc;
    }

    @Override
    public double get() {
        return -sc.get();
    }

    @Override
    public void set(double speed, byte syncGroup) {
        sc.set(-speed, syncGroup);
    }

    @Override
    public void set(double speed) {
        sc.set(-speed);
    }

    @Override
    public void disable() {
        sc.disable();
    }

    @Override
    public void pidWrite(double output) {
        sc.pidWrite(-output);
    }

}
