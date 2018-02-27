package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class SetElbowCommand extends Command {

    private IntakeDirection direction;
    private double totalCounter;
    private double currentCounter;
    private double speed;

    public SetElbowCommand(IntakeDirection direction, double moveSeconds) {
        this.direction = direction;
        totalCounter=moveSeconds*5;
        currentCounter = 0;
        speed = (direction == IntakeDirection.INTAKE) ? .2 : .25;
    }

    public static SetElbowCommand getSetCommand(IntakeDirection direction) {
        return new SetElbowCommand(direction, 1);
    }

    @Override
    protected void initialize() {
        Robot.arm.setElbowSpeed(IntakeDirection.applyDirection(speed, direction));
    }

    @Override
    protected void execute() {
        currentCounter++;
    }

    @Override
    protected boolean isFinished() {
        return currentCounter >= totalCounter;
    }

    @Override
    protected void end() {
        Robot.arm.setElbowSpeed(0);
    }

    @Override
    protected void interrupted() {
        Robot.arm.setElbowSpeed(0);
    }
}