package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class TeleopDriveCommand extends Command {

    public TeleopDriveCommand() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        double xSpeed = Robot.oi.getDriveStick().getRawAxis(RobotMap.JOYSTICK_DRIVE_LEFT_Y);
        double zRotation = Robot.oi.getDriveStick().getRawAxis(RobotMap.JOYSTICK_DRIVE_LEFT_X);
        Robot.driveTrain.driveRobot(xSpeed, zRotation);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
