package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;

public class Arm extends Subsystem {

    private SpeedController elbowController;
    private SpeedController wristController;

    public Arm() {
        this.elbowController = new PWMTalonSRX(RobotMap.ARM_ELBOW_PORT);
        this.wristController = new PWMTalonSRX(RobotMap.ARM_WRIST_PORT);
        wristController.setInverted(true);
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
        if(Robot.oi.getArmTrigger().get()) {
            Joystick armStick = Robot.oi.getArmStick();
            setWristSpeed(armStick.getRawAxis(1));
        } else if(wristController.get() != 0) {
            setWristSpeed(0);
        }
    }

    public SpeedController getWristController() {
        return wristController;
    }

    public double getWristSpeed() {
        return wristController.get();
    }
}
