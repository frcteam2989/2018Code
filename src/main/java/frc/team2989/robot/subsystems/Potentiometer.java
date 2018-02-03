package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Potentiometer extends Subsystem {

    private AnalogPotentiometer potentiometer;
    private SpeedController motor;

    public Potentiometer(int port, double initialAngle) {
        potentiometer = new AnalogPotentiometer(port, 360, initialAngle);
        motor = null;
    }

    @Override
    public void initDefaultCommand() {

    }

    public double get() {
        return potentiometer.get();
    }

    public AnalogPotentiometer getPotentiometer() {
        return potentiometer;
    }

    public void setMotorSpeed(double speed) {
        motor.set(speed);
    }

    public double setDirection(double baseSpeed) {
        return (moveForward()) ? baseSpeed : baseSpeed * -1;
    }

    private boolean moveForward() {
        return true;
    }
}
