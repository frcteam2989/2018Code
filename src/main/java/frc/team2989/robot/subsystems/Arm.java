package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.commandgroups.SetArmCommandGroup;

public class Arm extends Subsystem {

    private Potentiometer elbowPotentiometer;
    private Potentiometer wristPotentiometer;

    public Arm() {
        elbowPotentiometer = new Potentiometer(RobotMap.ARM_ELBOW_POTENTIOMETER_PORT, PotentiometerType.ELBOW);
        wristPotentiometer = new Potentiometer(RobotMap.ARM_WRIST_POTENTIOMETER_PORT, PotentiometerType.WRIST);
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
        System.out.printf("Elbow Potentiometer Angle: %2f\n Wrist Potentiometer Angle: %2f", elbowPotentiometer.get(), wristPotentiometer.get());
        System.out.printf("Elbow RAW: %2f\n Wrist RAW: %2f", elbowPotentiometer.getRaw(), wristPotentiometer.getRaw());

    }
}
