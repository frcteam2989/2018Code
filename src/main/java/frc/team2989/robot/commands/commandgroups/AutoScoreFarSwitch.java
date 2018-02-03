package frc.team2989.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.autonomous.AutoDrive;
import frc.team2989.robot.commands.autonomous.AutoLaunchCube;
import frc.team2989.robot.commands.autonomous.AutoTurn;
import openrio.powerup.MatchData;

import java.util.stream.Stream;

public class AutoScoreFarSwitch extends CommandGroup {

    public MatchData.OwnedSide side;
    
    public AutoScoreFarSwitch() {
        side = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
        Stream.of(
            new AutoDrive(RobotMap.AUTONOMOUS_FAR_DRIVE_DISTANCE, RobotMap.AUTONOMOUS_FAR_DRIVE_DEVIATION, RobotMap.AUTONOMOUS_FAR_DRIVE_SPEED, RobotMap.AUTONOMOUS_FAR_DRIVE_ROTATION)
            ,new AutoTurn(getTurnAngle(RobotMap.AUTONOMOUS_FAR_TURN_ANGLE), RobotMap.AUTONOMOUS_FAR_TURN_DEVIATION, RobotMap.AUTONOMOUS_FAR_TURN_ROTATION, RobotMap.AUTONOMOUS_FAR_TURN_SPEED)
            ,new AutoDrive(RobotMap.AUTONOMOUS_FAR_DRIVE_PAST_DISTANCE, RobotMap.AUTONOMOUS_FAR_DRIVE_PAST_DEVIATION, RobotMap.AUTONOMOUS_FAR_DRIVE_PAST_SPEED, RobotMap.AUTONOMOUS_FAR_DRIVE_PAST_ROTATION)
            ,new AutoTurn(getTurnAngle(RobotMap.AUTONOMOUS_FAR_TURN_PAST_ANGLE), RobotMap.AUTONOMOUS_FAR_TURN_PAST_DEVIATION, RobotMap.AUTONOMOUS_FAR_TURN_PAST_ROTATION, RobotMap.AUTONOMOUS_FAR_TURN_PAST_SPEED)
            ,new AutoDrive(RobotMap.AUTONOMOUS_FAR_DRIVE_TO_DISTANCE, RobotMap.AUTONOMOUS_FAR_DRIVE_TO_DEVIATION, RobotMap.AUTONOMOUS_FAR_DRIVE_TO_SPEED, RobotMap.AUTONOMOUS_FAR_DRIVE_TO_ROTATION)
            ,new AutoTurn(getTurnAngle(RobotMap.AUTONOMOUS_FAR_TURN_TO_ANGLE), RobotMap.AUTONOMOUS_FAR_TURN_TO_DEVIATION, RobotMap.AUTONOMOUS_FAR_TURN_TO_ROTATION, RobotMap.AUTONOMOUS_FAR_TURN_TO_SPEED)
            ,new AutoDrive(RobotMap.AUTONOMOUS_FAR_DRIVE_INTO_DISTANCE, RobotMap.AUTONOMOUS_FAR_DRIVE_INTO_DEVIATION, RobotMap.AUTONOMOUS_FAR_DRIVE_INTO_SPEED, RobotMap.AUTONOMOUS_FAR_DRIVE_INTO_ROTATION)
            ,new AutoLaunchCube(RobotMap.AUTONOMOUS_FAR_LAUNCH_SPEED)
        ).forEachOrdered(this::addSequential);
    }
    
    private double getTurnAngle(double baseTurnAngle) {
        return baseTurnAngle * (side == MatchData.OwnedSide.LEFT ? 1 : -1); 
    } 
}
