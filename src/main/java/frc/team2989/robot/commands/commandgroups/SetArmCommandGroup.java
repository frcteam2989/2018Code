package frc.team2989.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.Robot;
import frc.team2989.robot.commands.SetArmCommand;

import java.util.stream.Stream;

public class SetArmCommandGroup extends CommandGroup {

    public SetArmCommandGroup(double elbowAngle, double wristAngle) {
        requires(Robot.arm);
        Stream.of(
            new SetArmCommand(Robot.arm.getElbowPotentiometer(), elbowAngle)
           ,new SetArmCommand(Robot.arm.getWristPotentiometer(), wristAngle)
        ).forEach(this::addSequential);
    }
}
