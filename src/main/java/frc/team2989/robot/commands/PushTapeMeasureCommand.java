package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.subsystems.Intake;

public class PushTapeMeasureCommand extends Command {

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void initialize() {
        Robot.climbing.setTapeMeasureSpeed(1.0);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected void end() {
        Robot.climbing.setTapeMeasureSpeed(0);
    }

    @Override
    protected void interrupted() {
        Robot.climbing.setTapeMeasureSpeed(0);
    }
}
