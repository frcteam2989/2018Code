package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.subsystems.ArmPosition;

public class SetArmCommandGroup extends CommandGroup {

    public SetArmCommandGroup(ArmPosition position) {
        addSequential(new SetWristCommand(position.getAngle(), position.useFirstPotentiometer()));
        addSequential(new SetElbowCommand(position.getDirection(), .1));
    }
}
