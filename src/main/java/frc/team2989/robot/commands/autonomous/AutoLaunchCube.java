package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class AutoLaunchCube extends Command { // TODO: Implement after designing and implementing required arm subsystem

    public double speed;

    public AutoLaunchCube(double speed) {
        requires(Robot.driveTrain);
        this.speed = speed;
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
