package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;

public class PushRopeCommand extends Command {

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void initialize() {
        Robot.climbing.setGearboxSpeed(1.0);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected void end() {
        Robot.climbing.setGearboxSpeed(0);
    }

    @Override
    protected void interrupted() {
        Robot.climbing.setGearboxSpeed(0);
    }
}
