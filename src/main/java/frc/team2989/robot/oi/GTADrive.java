package frc.team2989.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.subsystems.DriveTrain;

public class GTADrive {

    Joystick stick;

    public GTADrive(Joystick stick) {
        this.stick = stick;
    }

    public void driveRobot() { //Is this code good nor nah?
        DriveTrain driveTrain = Robot.driveTrain;
        double leftTrigger = stick.getRawAxis(RobotMap.JOYSTICK_DRIVE_LEFT_TRIGGER);
        double rightTrigger = stick.getRawAxis(RobotMap.JOYSTICK_DRIVE_RIGHT_TRIGGER);
        DriveDirection direction = DriveDirection.fromTriggers(leftTrigger, rightTrigger);
        switch(direction) {
            case STOPPED:
               driveTrain.driveWheels(0, 0);
               return;
            default:
                double speed = stick.getRawAxis(RobotMap.JOYSTICK_DRIVE_LEFT_Y);
                speed*= -.5;
                speed+= .5;
                speed = DriveDirection. applyDirection(Math.abs(speed), direction);
                double turnRotation = stick.getRawAxis(RobotMap.JOYSTICK_DRIVE_RIGHT_X) * -1;
                driveTrain.driveRobot(speed, turnRotation);
                break;
        }
    }
}

