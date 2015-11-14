/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.responses.basicsystems;

import edu.wpi.first.wpilibj.SpeedController;
import eventbased.responses.Response;

/**
 *
 * @author thinkredstone
 */
public class MoveSpeedControllerResponse extends Response {

    private final SpeedController sc;
    private final double speed;

    public MoveSpeedControllerResponse(SpeedController sc, double speed) {
        this.sc = sc;
        this.speed = speed;
    }

    @Override
    protected void respond() {
        sc.set(speed);
    }

}
