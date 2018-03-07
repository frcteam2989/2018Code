package frc.team2989.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.Robot;
import frc.team2989.robot.commands.IntakeSpinCommand;
import frc.team2989.robot.subsystems.ArmPosition;

import java.util.stream.Stream;

public class AutoLaunchCube extends CommandGroup {

    public AutoLaunchCube(double speed, double seconds) {
        requires(Robot.driveTrain);
        requires(Robot.arm);
        requires(Robot.intake);
        Robot.driveTrain.stopRobot();
        Stream.of(
            ArmPosition.getByPosition(ArmPosition.SHOOT_FORWARD)
            ,new IntakeSpinCommand(IntakeDirection.OUTTAKE, speed, seconds)
        ).forEach(this::addSequential);
    }
}