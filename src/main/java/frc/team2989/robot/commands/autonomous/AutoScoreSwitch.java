package frc.team2989.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoScoreSwitch extends CommandGroup {

    public AutoScoreSwitch() {
        addSequential(new AutoDriveToSwitch());
        addSequential(new AutoTurnToSwitch());
        addSequential(new AutoDropCube());
    }
}
