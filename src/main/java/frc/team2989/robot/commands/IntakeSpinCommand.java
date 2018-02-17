package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.subsystems.Intake;

public class IntakeSpinCommand extends Command {

    private Intake.Direction direction;
    private double distance;
    private double deviation;
    private double speed;

    public IntakeSpinCommand(Intake.Direction direction, double speed) {
        this.direction = direction;
        this.distance = RobotMap.INTAKE_CUBE_DISTANCE;
        this.deviation = RobotMap.INTAKE_CUBE_DEVIATION;
        this.speed = speed;
    }

    @Override
    protected void initialize() {
        Robot.intake.setMotorSpeed(RobotMap.INTAKE_SPEED, direction);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        /*if(direction == Intake.Direction.INTAKE) {
            double currentDistance = Robot.ultrasonicSensor.getRangeInches();
            return (currentDistance >= (distance - deviation) && currentDistance <= (distance + deviation));
        }*/
        return false;
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
