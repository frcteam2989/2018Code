package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.subsystems.Potentiometer;

public class SetArmCommand extends Command {

    private Potentiometer potentiometer;
    private double angle;
    private double deviation;

    public SetArmCommand(Potentiometer potentiometer, double angle) {
        this.potentiometer = potentiometer;
        this.angle = angle;
        this.deviation = RobotMap.ARM_ANGLE_DEVIATION;
    }

    @Override
    protected void initialize() {
        potentiometer.setMotorSpeed(potentiometer.setDirection(RobotMap.ARM_MOVEMENT_SPEED));
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        double currentAngle = potentiometer.get();
        return (currentAngle >= (angle - deviation) && currentAngle <= (angle + deviation));
    }

    @Override
    protected void end() {
        potentiometer.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {

    }
}
