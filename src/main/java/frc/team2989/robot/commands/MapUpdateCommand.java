package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2989.robot.RobotMap;

/**
 * @author Andy Phan
 */
public class MapUpdateCommand extends Command {

    @Override
    protected void initialize(){}

    @Override
    protected void execute(){
        RobotMap.update();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end(){}

    @Override
    protected  void interrupted(){}
}
