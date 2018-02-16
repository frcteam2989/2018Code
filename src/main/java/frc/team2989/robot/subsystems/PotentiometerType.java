package frc.team2989.robot.subsystems;

import frc.team2989.robot.RobotMap;

public enum PotentiometerType {

    ELBOW,
    WRIST;

    public int getMotorPort() {
        switch(this) {
            case ELBOW:
                return RobotMap.ARM_ELBOW_PORT;
            case WRIST:
                return RobotMap.ARM_WRIST_PORT;
            default:
                return -1;
        }
    }
}
