/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limitbased;

/**
 *
 * @author thinkredstone
 */
public interface LimitedSystem {

    public void forward(double speed);

    public void backwards(double speed);

    public boolean isForward();

    public boolean isBackwards();
}
