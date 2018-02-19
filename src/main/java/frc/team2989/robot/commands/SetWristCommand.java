package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.oi.Direction;
import frc.team2989.robot.subsystems.Potentiometer;

public class SetWristCommand extends Command {

    private Potentiometer potentiometer;
    private double finalValue;
    private double deviation;
    private Direction direction;

    public SetWristCommand(double finalPotentiometerValue, boolean useSecondPotentiometer) {
        this.potentiometer = (useSecondPotentiometer) ? Robot.secondWristPotentiometer : Robot.wristPotentiometer;
        this.finalValue = finalPotentiometerValue;
        this.deviation = RobotMap.ARM_ANGLE_DEVIATION;
        this.direction = (finalPotentiometerValue - potentiometer.get()) > 0 ? Direction.FORWARD : Direction.REVERSE;
        direction = (useSecondPotentiometer) ? reverseDirection(direction) : direction;
    }

    @Override
    protected void initialize() {
        potentiometer.setMotorSpeed(potentiometer.setDirection(direction, RobotMap.ARM_MOVEMENT_SPEED));
    }

    @Override
    protected void execute() {
        potentiometer.setMotorSpeed(potentiometer.setDirection(direction, RobotMap.ARM_MOVEMENT_SPEED));
    }

    @Override
    protected boolean isFinished() {
        double currentAngle = potentiometer.get();
        return (direction == Direction.FORWARD) ? finalValue <= currentAngle : finalValue <= currentAngle;
    }

    @Override
    protected void end() {
        potentiometer.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
        potentiometer.setMotorSpeed(0);
    }

    private Direction reverseDirection(Direction direction) {
        return (direction == Direction.FORWARD) ? Direction.REVERSE : Direction.FORWARD;
    }

}
