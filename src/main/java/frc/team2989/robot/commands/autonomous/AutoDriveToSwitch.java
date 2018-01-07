package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class AutoDriveToSwitch extends Command {

    public double distanceDriven = 0;

    public AutoDriveToSwitch() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.driveEncoder.reset();
        distanceDriven = Robot.driveEncoder.getDistance();
    }

    @Override
    protected void execute() {
        Robot.driveTrain.driveRobot(RobotMap.AUTONOMOUS_DRIVE_SPEED, 0);
        distanceDriven = Robot.driveEncoder.getDistance();
    }

    @Override
    protected boolean isFinished() {
        return isNearSwitch();
    }

    private boolean isNearSwitch() {
        double distance = Robot.driveEncoder.getDistance();
        return (distance >= (RobotMap.AUTONOMOUS_DRIVE_DISTANCE - RobotMap.AUTONOMOUS_DRIVE_DEVIATION) && distance <= (RobotMap.AUTONOMOUS_DRIVE_DISTANCE + RobotMap.AUTONOMOUS_DRIVE_DEVIATION));
    }
    @Override
    protected void end() {
        Robot.driveTrain.stopRobot();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
