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
 * @author thinkredstone A system that is only limited backwards
 */
public class OneLimitSystem implements LimitedSystem {

    private SpeedController sc;
    private DigitalInput backwards;

    @Override
    public void forward(double speed) {
        sc.set(speed);
    }

    @Override
    public void backwards(double speed) {
        if (!isBackwards()) {
            sc.set(-speed);
        } else {
            sc.set(0);
        }
    }

    @Override
    public boolean isForward() {
        //A system limited only backwards is never forward
        return false;
    }

    @Override
    public boolean isBackwards() {
        return backwards.get();
    }

}
