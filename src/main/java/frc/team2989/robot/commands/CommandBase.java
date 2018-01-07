package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {

    @Override
    protected boolean isFinished() {
        return false;
    }

    public static void init() {

    }
}
