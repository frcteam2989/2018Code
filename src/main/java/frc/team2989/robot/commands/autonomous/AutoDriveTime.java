package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class AutoDriveTime extends Command {

    private double targetDistance;
    private double deviation;
    private double speed;
    private double rotation;
    private double counter;

    public AutoDriveTime(double distance, double deviation, double speed, double rotation) {
        requires(Robot.driveTrain);
        this.targetDistance = distance;
        this.deviation = deviation;
        this.speed = speed;
        this.rotation = rotation;
    }

    @Override
    protected void initialize() {
        counter = 0;
    }

    @Override
    protected void execute() {
        counter++;
        Robot.driveTrain.driveRobot(speed, rotation);
    }

    @Override
    protected boolean isFinished() {
        return isNearSwitch();
    }

    private boolean isNearSwitch() {
        double currentDistance = getDistance();
        return (currentDistance >= (targetDistance - deviation) && currentDistance <= (targetDistance + deviation));
    }
    @Override
    protected void end() {
        Robot.driveTrain.stopRobot();
    }

    @Override
    protected void interrupted() {
        end();
    }

    private double getDistance() {
        return (counter * 5) * RobotMap.AUTONOMOUS_DISTANCE_PER_SECOND;
    }
}
