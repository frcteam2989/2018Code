package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;

public class Gyro extends Subsystem {

    private AnalogGyro gyro;


    public Gyro() {
        gyro = new AnalogGyro(RobotMap.SENSORS_GYRO_PORT);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public AnalogGyro getGyro() {
        return gyro;
    }

    public void reset() {
        gyro.reset();
    }

    public double getAngle() {
        return gyro.getAngle();
    }

}
