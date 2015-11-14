/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limitbased;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author thinkredstone
 */
public class TwoLimitSystem implements LimitedSystem {

    private SpeedController sc;
    private DigitalInput forward, backwards;

    public TwoLimitSystem(SpeedController sc, DigitalInput forward, DigitalInput backwards) {
        this.sc = sc;
        this.forward = forward;
        this.backwards = backwards;
    }

    @Override
    public void forward(double speed) {
        sc.set(speed);
    }

    @Override
    public void backwards(double speed) {
        sc.set(-speed);
    }

    @Override
    public boolean isForward() {
        return forward.get();
    }

    @Override
    public boolean isBackwards() {
        return backwards.get();
    }

}
