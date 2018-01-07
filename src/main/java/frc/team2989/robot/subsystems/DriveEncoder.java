package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;

public class DriveEncoder extends Subsystem {

    private Encoder driveEncoder;

    public DriveEncoder() {
        driveEncoder = new Encoder(RobotMap.SENSORS_ENCODER_DRIVE_PORT1, RobotMap.SENSORS_ENCODER_DRIVE_PORT2);
        driveEncoder.setDistancePerPulse(RobotMap.SENSORS_ENCODER_DRIVE_DISTANCE_PER_PULSE);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public Encoder getDriveEncoder() {
        return driveEncoder;
    }

    public void reset() {
        driveEncoder.reset();
    }

    public double getDistance() {
        return driveEncoder.getDistance();
    }

    public boolean getDirection() {
        return driveEncoder.getDirection();
    }
}
