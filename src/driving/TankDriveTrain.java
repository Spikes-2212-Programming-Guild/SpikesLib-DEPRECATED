/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driving;

import components.Gearbox;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author thinkredstone
 */
public class TankDriveTrain implements Tank {

    private SpeedController left, right;

    public TankDriveTrain(SpeedController left, SpeedController right) {
        this.left = left;
        this.right = right;
    }

    public TankDriveTrain(SpeedController leftFront, SpeedController leftRear, SpeedController rightFront, SpeedController rightRear) {
        left = new Gearbox(leftFront, leftRear);
        right = new Gearbox(rightFront, rightRear);
    }

    @Override
    public void setRight(double speed) {
        right.set(speed);
    }

    @Override
    public void setLeft(double speed) {
        left.set(speed);
    }

    public void forward(double speed) {
        left.set(-speed);
        right.set(speed);
    }

    public void turn(double speed) {
        left.set(speed);
        right.set(speed);
    }

}
