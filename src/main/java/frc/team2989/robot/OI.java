package frc.team2989.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    Joystick driveStick;

    public OI() {
        super();
        driveStick = new Joystick(RobotMap.JOYSTICK_DRIVE_PORT);
    }

    public Joystick getDriveStick() {
        return driveStick;
    }
}
