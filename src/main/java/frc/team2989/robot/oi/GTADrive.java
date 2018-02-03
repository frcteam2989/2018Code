package frc.team2989.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import frc.team2989.robot.RobotMap;

public class GTADrive {

    Joystick stick;

    public GTADrive(Joystick stick) {
        this.stick = stick;
    }

    public void driveRobot() { //Is this code good nor nah?
        double leftTrigger = stick.getRawAxis(RobotMap.JOYSTICK_DRIVE_LEFT_TRIGGER);
        double rightTrigger = stick.getRawAxis(RobotMap.JOYSTICK_DRIVE_RIGHT_TRIGGER);
    }
}

