package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;

public class Arm extends Subsystem {

    private Potentiometer elbowPotentiometer;
    private Potentiometer wristPotentiometer;

    public Arm() {
        elbowPotentiometer = new Potentiometer(RobotMap.ARM_ELBOW_POTENTIOMETER_PORT, RobotMap.ARM_ELBOW_POTENTIOMETER_OFFSET);
        wristPotentiometer = new Potentiometer(RobotMap.ARM_WRIST_POTENTIOMETER_PORT, RobotMap.ARM_WRIST_POTENTIOMETER_OFFSET);
    }
    @Override
    public void initDefaultCommand() {

    }

    public void moveArm(double armAngle, double wristAngle) {
        double angleDeviation = RobotMap.ARM_ANGLE_DEVIATION;

    }

    public Potentiometer getElbowPotentiometer() {
        return elbowPotentiometer;
    }

    public Potentiometer getWristPotentiometer() {
        return wristPotentiometer;
    }
}
