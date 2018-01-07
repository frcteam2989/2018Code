package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class AutoDropCube extends Command {

    public double distanceDriven = 0;

    public AutoDropCube() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.driveTrain.stopRobot();
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
