package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.RobotMap;

public class AutoCrossLine extends CommandGroup {

    public AutoCrossLine() {
        addSequential(new AutoDriveTime(RobotMap.AUTONOMOUS_CLOSE_DRIVE_DISTANCE, RobotMap.AUTONOMOUS_CLOSE_DRIVE_DEVIATION, RobotMap.AUTONOMOUS_CLOSE_DRIVE_SPEED, RobotMap.AUTONOMOUS_CLOSE_DRIVE_ROTATION));
    }
}
