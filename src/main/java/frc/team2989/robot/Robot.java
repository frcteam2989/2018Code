package frc.team2989.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team2989.robot.commands.UpdateRobotMapCommand;
import frc.team2989.robot.commands.autonomous.AutoCrossLine;
import frc.team2989.robot.commands.commandgroups.AutoScoreCloseSwitch;
import frc.team2989.robot.oi.OI;
import frc.team2989.robot.subsystems.*;
import openrio.powerup.MatchData;

import java.util.stream.IntStream;

public class Robot extends IterativeRobot {

    public static DriveTrain driveTrain;
    public static Gyro gyro;
    public static DriveEncoder driveEncoder;
    public static Arm arm;
    public static Intake intake;
    public static Climbing climbing;
    public static Potentiometer wristPotentiometer;
    public static Potentiometer secondPotentiometer;
    public static OI oi;
    public static Command autonomousCommand;
    SendableChooser<MatchData.OwnedSide> chooser;
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
        secondPotentiometer = new Potentiometer(RobotMap.ARM_SECOND_WRIST_POTENTIOMETER_PORT, PotentiometerType.WRIST);
        climbing = new Climbing();
        oi = new OI();
        setLiveWindow();
        updateDashboard();
        setupChooser();
        UpdateRobotMapCommand updateRobotMapCommand = new UpdateRobotMapCommand();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    /*@Override
    public void autonomousInit() {
        MatchData.OwnedSide switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
        MatchData.OwnedSide robotSide = chooser.getSelected();
        boolean canDeliver = robotSide == switchSide;
        autonomousCommand = (canDeliver) ? new AutoScoreCloseSwitch() : new AutoCrossLine();
        autonomousCommand.start();
    }   */

    public void autonomousInit() {
        autonomousCommand = new AutoCrossLine();
        autonomousCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        updateDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if(autonomousCommand != null) {
            autonomousCommand.cancel();
        }
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
        SmartDashboard.putNumber("Potentiometer 2", secondPotentiometer.get());
        RobotMap.update();
    }

    public static void setLiveWindow() {
        // Add sensors
        // LiveWindow.add(gyro.getGyro());
        LiveWindow.add(wristPotentiometer.getPotentiometer());
        LiveWindow.add(secondPotentiometer.getPotentiometer());

        // Add actuators
        LiveWindow.setEnabled(true);
    }

    private void setupChooser() {
        chooser = new SendableChooser<>();
        chooser.addDefault("Left Side (close delivery or none)", MatchData.OwnedSide.LEFT);
        chooser.addObject("Right Side (close delivery or none)", MatchData.OwnedSide.RIGHT);
        SmartDashboard.putData("Autonomous Command Chooser (PICK THIS)", chooser);
        
    }
}