package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.RobotMap;

public class AutoScoreCloseSwitch extends CommandGroup {

    public AutoScoreCloseSwitch() {
        addSequential(new AutoDrive(RobotMap.AUTONOMOUS_CLOSE_DRIVE_DISTANCE, RobotMap.AUTONOMOUS_CLOSE_DRIVE_DEVIATION, RobotMap.AUTONOMOUS_CLOSE_DRIVE_SPEED, RobotMap.AUTONOMOUS_CLOSE_DRIVE_ROTATION));
        addSequential(new AutoTurn(RobotMap.AUTONOMOUS_CLOSE_TURN_ANGLE, RobotMap.AUTONOMOUS_CLOSE_TURN_DEVIATION, RobotMap.AUTONOMOUS_CLOSE_TURN_ROTATION, RobotMap.AUTONOMOUS_CLOSE_TURN_SPEED));
        addSequential(new AutoLaunchCube(RobotMap.AUTONOMOUS_CLOSE_LAUNCH_SPEED));
    }
}
