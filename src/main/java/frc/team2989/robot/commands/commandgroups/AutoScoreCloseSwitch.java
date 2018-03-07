package frc.team2989.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.autonomous.AutoDriveEncoder;
import frc.team2989.robot.commands.autonomous.AutoTurn;
import openrio.powerup.MatchData;

import java.util.stream.Stream;

public class AutoScoreCloseSwitch extends CommandGroup {

    public AutoScoreCloseSwitch() {
        MatchData.OwnedSide ownedSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
        double turnAngle = RobotMap.AUTONOMOUS_CLOSE_TURN_ANGLE * ((ownedSide == MatchData.OwnedSide.LEFT) ? 1 : -1);
        Stream.of(
            new AutoDriveEncoder(RobotMap.AUTONOMOUS_CLOSE_DRIVE_DISTANCE, RobotMap.AUTONOMOUS_CLOSE_DRIVE_DEVIATION, RobotMap.AUTONOMOUS_CLOSE_DRIVE_SPEED, RobotMap.AUTONOMOUS_CLOSE_DRIVE_ROTATION),
            new AutoTurn(turnAngle, RobotMap.AUTONOMOUS_CLOSE_TURN_DEVIATION, RobotMap.AUTONOMOUS_CLOSE_TURN_ROTATION, RobotMap.AUTONOMOUS_CLOSE_TURN_SPEED),
            new AutoLaunchCube(RobotMap.AUTONOMOUS_CLOSE_LAUNCH_SPEED, 1)
        ).forEachOrdered(this::addSequential);
    }
}
