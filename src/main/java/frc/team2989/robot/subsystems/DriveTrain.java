package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.TeleopDriveCommand;

public class DriveTrain extends Subsystem {

    private static DifferentialDrive drive;

    public DriveTrain() {
        PWMTalonSRX leftTalon = new PWMTalonSRX(RobotMap.MOTOR_DRIVE_LEFT);
        PWMTalonSRX rightTalon = new PWMTalonSRX(RobotMap.MOTOR_DRIVE_RIGHT);
        drive = new DifferentialDrive(leftTalon, rightTalon);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDriveCommand());
    }

    public void driveRobot(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation);
    }

    public void stopRobot() {
        drive.arcadeDrive(0, 0);
    }
}
