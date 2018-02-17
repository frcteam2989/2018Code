package frc.team2989.robot.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.Robot;
import frc.team2989.robot.commands.SetArmCommand;
import frc.team2989.robot.subsystems.ArmPosition;

import java.util.stream.Stream;

public class SetArmCommandGroup extends CommandGroup {

    public SetArmCommandGroup(ArmPosition position) {
       /* requires(Robot.arm);
        Stream.of(
            new SetArmCommand(Robot.arm.getElbowPotentiometer(), position.getElbowAngle())
           ,new SetArmCommand(Robot.arm.getWristPotentiometer(), position.getWristAngle())
        ).forEach(this::addSequential);*/
    }
}
