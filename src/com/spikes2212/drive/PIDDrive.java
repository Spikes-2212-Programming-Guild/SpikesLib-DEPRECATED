/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.drive;

/**
 *
 * @author thinkredstone
 */
public interface PIDDrive {

    void pidSet(double speed);

    double get();
}
