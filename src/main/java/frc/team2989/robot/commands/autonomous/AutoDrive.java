package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;

public class AutoDrive extends Command {

    public double distanceDriven = 0;

    private double distance;
    private double deviation;
    private double speed;
    private double rotation;

    public AutoDrive(double distance, double deviation, double speed, double rotation) {
        requires(Robot.driveTrain);
        this.distance = distance;
        this.deviation = deviation;
        this.speed = speed;
        this.rotation = rotation;
    }

    @Override
    protected void initialize() {
        Robot.driveEncoder.reset();
        distanceDriven = Robot.driveEncoder.getDistance();
    }

    @Override
    protected void execute() {
        Robot.driveTrain.driveRobot(speed, rotation);
        distanceDriven = Robot.driveEncoder.getDistance();
    }

    @Override
    protected boolean isFinished() {
        return isNearSwitch();
    }

    private boolean isNearSwitch() {
        double currentDistance = Robot.driveEncoder.getDistance();
        return (currentDistance >= (distance - deviation) && currentDistance <= (distance + deviation));
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
