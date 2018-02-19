package frc.team2989.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team2989.robot.commands.UpdateRobotMapCommand;
import frc.team2989.robot.oi.OI;
import frc.team2989.robot.subsystems.*;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Robot extends IterativeRobot {

    public static DriveTrain driveTrain;
    public static Gyro gyro;
    public static DriveEncoder driveEncoder;
    public static Arm arm;
    public static Intake intake;
    public static Climbing climbing;
    public static Potentiometer wristPotentiometer;
    public static Potentiometer secondWristPotentiometer;
    public static OI oi;
    private static UpdateRobotMapCommand updateRobotMapCommand;
    Preferences robotPreferences;

    @Override
    public void robotInit() {
        IntStream.of(0, 1).forEach(CameraServer.getInstance()::startAutomaticCapture);
        driveTrain = new DriveTrain();
        // gyro = new Gyro();
        // driveEncoder = new DriveEncoder();
        arm = new Arm();
        intake = new Intake();
        wristPotentiometer = new Potentiometer(RobotMap.ARM_WRIST_POTENTIOMETER_PORT, PotentiometerType.WRIST);
        secondWristPotentiometer = new Potentiometer(RobotMap.ARM_SECOND_WRIST_POTENTIOMETER_PORT, PotentiometerType.WRIST);
        climbing = new Climbing();
        oi = new OI();
        // autonomousCommand = new AutoScoreCloseSwitch();
        setLiveWindow();
        updateDashboard();
        updateRobotMapCommand = new UpdateRobotMapCommand();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {
        updateDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        updateDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }

    public static void updateDashboard() {
        // SmartDashboard.putNumber("Wrist Potentiometer Value", wristPotentiometer.get());
        // SmartDashboard.putNumber("Wrist Potentiometer 2 Value", wristPotentiometer.get());
        // SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
        SmartDashboard.putNumber("Potentiometer 1", wristPotentiometer.get());
        SmartDashboard.putNumber("Potentiometer 2", secondWristPotentiometer.get());
        RobotMap.update();
    }

    public static void setLiveWindow() {
        // Add sensors
        // LiveWindow.add(gyro.getGyro());
        LiveWindow.add(wristPotentiometer.getPotentiometer());
        LiveWindow.add(secondWristPotentiometer.getPotentiometer());

        // Add actuators
        LiveWindow.setEnabled(true);
    }

}