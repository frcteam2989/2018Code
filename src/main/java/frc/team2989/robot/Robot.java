package frc.team2989.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import frc.team2989.robot.commands.autonomous.AutoScoreSwitch;
import frc.team2989.robot.subsystems.DriveEncoder;
import frc.team2989.robot.subsystems.DriveTrain;
import frc.team2989.robot.subsystems.Gyro;

import java.util.stream.Stream;

public class Robot extends IterativeRobot {

    public static DriveTrain driveTrain;
    public static Gyro gyro;
    public static DriveEncoder driveEncoder;
    public static OI oi;
    private static CommandGroup autonomousCommand;
    Preferences robotPreferences;

    @Override
    public void robotInit() {
        updatePreferences();
        driveTrain = new DriveTrain();
        gyro = new Gyro();
        driveEncoder = new DriveEncoder();
        oi = new OI();
        autonomousCommand = new AutoScoreSwitch();

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void autonomousInit() {
        autonomousCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
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
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void updatePreferences() {
        RobotMap.update();
    }
}