/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.commandbased;

/**
 *
 * @author thinkredstone
 */
public interface Command extends Runnable {
    boolean isFinished();
    void end();
}
