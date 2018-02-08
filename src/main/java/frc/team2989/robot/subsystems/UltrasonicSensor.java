package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.team2989.robot.RobotMap;

public class UltrasonicSensor {

    private Ultrasonic ultrasonic;

    public UltrasonicSensor() {
        this.ultrasonic = new Ultrasonic(RobotMap.INTAKE_ULTRASONIC_PORT, RobotMap.INTAKE_ULTRASONIC_PORT);
    }

    public double getRangeInches() {
        return ultrasonic.getRangeInches();
    }
}
