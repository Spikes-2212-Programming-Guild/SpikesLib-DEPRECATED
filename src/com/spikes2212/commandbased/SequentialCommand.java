/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spikes2212.commandbased;

import com.spikes2212.robot.DriveTrain;
import com.spikes2212.robot.invokers.drive.PIDDriveInvoker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author thinkredstone
 */
public class SequentialCommand implements Command {

    private List<Command> commands;
    private int index = 0;

    public SequentialCommand(Command[] commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    public boolean isFinished() {
        return index >= commands.size();
    }

    @Override
    public void end() {
        index = 0;
    }

    @Override
    public void run() {
        commands.get(index).run();
        if (commands.get(index).isFinished()) {
            commands.get(index).end();
            index++;
        }

    }

}
