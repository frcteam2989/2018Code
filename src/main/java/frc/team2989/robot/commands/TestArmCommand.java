package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.oi.DriveDirection;
import frc.team2989.robot.subsystems.Potentiometer;

public class TestArmCommand extends Command {


    private Potentiometer potentiometer;

    public TestArmCommand(Potentiometer potentiometer) {
        this.potentiometer = potentiometer;

    }

    @Override
    protected void initialize() {
        potentiometer.setMotorSpeed(.1);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        potentiometer.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
        potentiometer.setMotorSpeed(0);
    }
}
