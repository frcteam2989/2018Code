package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.subsystems.Intake;

public class IntakeSpinCommand extends Command {

    private IntakeDirection direction;
    private double speed;
    private int counter;
    private double maxCounter;

    public IntakeSpinCommand(IntakeDirection direction, double speed) {
        this.maxCounter = -1;
        this.direction = direction;
        this.speed = speed;
    }

    public IntakeSpinCommand(IntakeDirection direction, double speed, double seconds) {
        this.direction = direction;
        this.speed = speed;
        this.maxCounter = seconds * 5;
    }

    @Override
    protected void initialize() {
        counter = 0;
        Robot.intake.setMotorSpeed(speed, direction);
    }

    @Override
    protected void execute() {
        counter++;
    }

    @Override
    protected boolean isFinished() {
        return (counter != -1) && counter >= maxCounter;
    }

    @Override
    protected void end() {
        Robot.intake.stopMotor();
    }

    @Override
    protected void interrupted() {
        Robot.intake.stopMotor();
    }
}
