package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class ClimbCommand extends Command {

    public ClimbCommand() {requires(Robot.climbing);}


    @Override
    protected void initialize() {
        Robot.climbing.setGearboxSpeed(RobotMap.CLIMBING_SPEED);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
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
