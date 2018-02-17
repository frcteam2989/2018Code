package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class ManualArm extends Subsystem {

    private SpeedController elbowController;
    private SpeedController wristController;

    public ManualArm() {
        this.elbowController = new PWMTalonSRX(RobotMap.ARM_ELBOW_PORT);
        this.wristController = new PWMTalonSRX(RobotMap.ARM_WRIST_PORT);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void setElbowSpeed(double speed) {
        elbowController.set(speed);
    }

    public void setWristSpeed(double speed) {
        wristController.set(speed);
    }

    public void move() {
        Joystick armStick = Robot.oi.getArmStick();
        setWristSpeed(-1*armStick.getRawAxis(1));
    }
}
