package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.Robot;

public class UpdateRobotMapCommand extends Command {

    private int counter;

    public UpdateRobotMapCommand() {

    }

    @Override
    protected void initialize() {
        counter = 0;
    }

    @Override
    protected void execute() {
        boolean callUpdate = (counter == 500);
        if(callUpdate) {
            Robot.updateDashboard();
        }
        counter = (callUpdate) ? 0 : counter+1;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
