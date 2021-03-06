package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.oi.Direction;

public class Potentiometer extends Subsystem {

    private AnalogPotentiometer potentiometer;
    private PotentiometerType potentiometerType;
    private SpeedController motor;

    public Potentiometer(int port, PotentiometerType type) {
        potentiometer = new AnalogPotentiometer(port, RobotMap.POTENTIOMETER_TOTAL_DISTANCE, .08);
        this.potentiometerType = type;
        motor = Robot.arm.getWristController();
    }

    @Override
    public void initDefaultCommand() {

    }

    public double getRaw() {
        return potentiometer.get();
    }

    public double get() {
        return getRaw();
    }

    /*public double get() {
        double potentiometerOutput = getRaw();

        double a = (potentiometerType == PotentiometerType.WRIST) ? RobotMap.POTENTIOMETER_WRIST_FIRST_ANGLE_LENGTH : RobotMap.POTENTIOMETER_ELBOW_FIRST_ANGLE_LENGTH;
        double b = (potentiometerType == PotentiometerType.WRIST) ? RobotMap.POTENTIOMETER_WRIST_SECOND_ANGLE_LENGTH : RobotMap.POTENTIOMETER_ELBOW_SECOND_ANGLE_LENGTH;

        return Math.acos((Math.pow(potentiometerOutput, 2) - Math.pow(a, 2) - Math.pow(b, 2)) / (-2*a*b));
    }*/

    public AnalogPotentiometer getPotentiometer() {
        return potentiometer;
    }

    public void setMotorSpeed(double speed) {
        motor.set(speed);
    }

    public double setDirection(Direction direction, double baseSpeed) {
        return (direction == Direction.REVERSE) ? baseSpeed : baseSpeed * -1;
    }

    private boolean moveForward(double desiredAngle) {
        return get() >= desiredAngle;
    }

    public PotentiometerType getPotentiometerType() {
        return potentiometerType;
    }
}

