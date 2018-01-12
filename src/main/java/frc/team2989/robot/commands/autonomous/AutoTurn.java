package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class AutoTurn extends Command {
    public double turnAngle = 0;
    
    private double angle;
    private double deviation;
    private double rotation;
    private double speed;

    public AutoTurn(double angle, double deviation, double rotation, double speed) {
        requires(Robot.driveTrain);
        this.angle = angle;
        this.deviation = deviation;
        this.rotation = rotation;
        this.speed = speed;
    }

    @Override
    protected void initialize() {
        Robot.driveEncoder.reset();
        turnAngle = Robot.gyro.getAngle();
    }

    @Override
    protected void execute() {
        Robot.driveTrain.driveRobot(speed, rotation);
        turnAngle = Robot.gyro.getAngle();
    }

    @Override
    protected boolean isFinished() {
        return isTurned();
    }

    private boolean isTurned() {
        double currentAngle = Robot.gyro.getAngle();
        return (currentAngle >= (angle - deviation) && currentAngle <= (angle + deviation));
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
