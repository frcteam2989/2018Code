package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;

public class DebugArmCommand extends Command {

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void initialize() {
        System.out.println("*** BEGIN DEBUG ***");
    }

    @Override
    protected void execute() {
        Robot.arm.debugAngles();
    }

    @Override
    protected void end() {
        System.out.println("*** END DEBUG ***");
    }

    @Override
    protected void interrupted() {
        System.out.println("*** INTERRUPT DEBUG");
    }
}
