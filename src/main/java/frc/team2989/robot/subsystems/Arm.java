package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.DebugArmCommand;
import frc.team2989.robot.commands.commandgroups.SetArmCommandGroup;

public class Arm extends Subsystem {

    private Potentiometer elbowPotentiometer;
    private Potentiometer wristPotentiometer;

    public Arm() {
        elbowPotentiometer = new Potentiometer(RobotMap.ARM_ELBOW_POTENTIOMETER_PORT, RobotMap.ARM_ELBOW_POTENTIOMETER_OFFSET, PotentiometerType.ELBOW);
        wristPotentiometer = new Potentiometer(RobotMap.ARM_WRIST_POTENTIOMETER_PORT, RobotMap.ARM_WRIST_POTENTIOMETER_OFFSET, PotentiometerType.WRIST);
    }

    @Override
    public void initDefaultCommand() {

    }

    public SetArmCommandGroup getMoveCommand(ArmPosition position) {
        return new SetArmCommandGroup(position);
    }

    public Potentiometer getElbowPotentiometer() {
        return elbowPotentiometer;
    }
    public Potentiometer getWristPotentiometer() {
        return wristPotentiometer;
    }

    public void debugAngles() {
        System.out.printf("Elbow Potentiometer Angle: %2f\nWrist Potentiometer Angle: %2f", elbowPotentiometer.get(), wristPotentiometer.get());
    }
}
