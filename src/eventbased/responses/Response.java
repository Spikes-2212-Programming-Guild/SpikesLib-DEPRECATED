/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventbased.responses;

import eventbased.events.Event;

/**
 *
 * @author thinkredstone
 */
public abstract class Response implements Event, Runnable {
    private boolean isRunning;

    protected abstract void respond();

    @Override
    public boolean isHappening() {
        return isRunning;
    }

    @Override
    public void run() {
        isRunning = true;
        respond();
        isRunning = false;
    }

}
