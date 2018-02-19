package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.oi.GTADrive;

public class TeleopDriveCommand extends Command {

    private GTADrive gtaDrive;

    public TeleopDriveCommand() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        this.gtaDrive =  new GTADrive(Robot.oi.getDriveStick());
    }

    @Override
    protected void execute() {
        gtaDrive.driveRobot();
        Robot.arm.move();
        Robot.climbing.moveTapeMeasure();
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
