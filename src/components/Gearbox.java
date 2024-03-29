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
 * @param <SpeedController> Type of Speed controller
 */
public class Gearbox implements SpeedController {

    private SpeedController front, rear;

    public Gearbox(SpeedController front, SpeedController rear) {
        this.front = front;
        this.rear = rear;
    }

    public double get() {
        return (front.get() + rear.get()) / 2;
    }

    public void set(double d, byte b) {
        front.set(d, b);
        rear.set(d, b);
    }

    public void set(double d) {
        front.set(d);
        rear.set(d);
    }

    public void disable() {
        front.disable();
        rear.disable();
    }

    public void pidWrite(double d) {
        front.pidWrite(d);
        rear.pidWrite(d);
    }

}
