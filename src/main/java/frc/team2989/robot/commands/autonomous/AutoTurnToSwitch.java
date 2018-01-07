package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class AutoTurnToSwitch extends Command {
    public double turnAngle = 0;

    public AutoTurnToSwitch() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.driveEncoder.reset();
        turnAngle = Robot.gyro.getAngle();
    }

    @Override
    protected void execute() {
        Robot.driveTrain.driveRobot(RobotMap.AUTONOMOUS_TURN_SPEED, RobotMap.AUTONOMOUS_TURN_ROTATION);
        turnAngle = Robot.gyro.getAngle();
    }

    @Override
    protected boolean isFinished() {
        return isTurned();
    }

    private boolean isTurned() {
        double angle = Robot.gyro.getAngle();
        return (angle >= (RobotMap.AUTONOMOUS_TURN_ANGLE - RobotMap.AUTONOMOUS_TURN_DEVIATION) && angle <= (RobotMap.AUTONOMOUS_TURN_ANGLE + RobotMap.AUTONOMOUS_TURN_DEVIATION));
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
