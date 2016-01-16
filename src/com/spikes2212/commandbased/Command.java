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
public abstract class Command implements Runnable {

    @Override
    public void run() {
    }
    
   public abstract boolean isFinished();
   public abstract void end();
}
