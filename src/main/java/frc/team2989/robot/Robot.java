package frc.team2989.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import frc.team2989.robot.commands.UpdateRobotMapCommand;
import frc.team2989.robot.oi.OI;
import frc.team2989.robot.subsystems.Arm;
import frc.team2989.robot.subsystems.DriveEncoder;
import frc.team2989.robot.subsystems.DriveTrain;
import frc.team2989.robot.subsystems.Gyro;

public class Robot extends IterativeRobot {

    public static DriveTrain driveTrain;
    public static Gyro gyro;
    public static DriveEncoder driveEncoder;
    public static Arm arm;
    public static OI oi;
    private static CommandGroup autonomousCommand;
    private static UpdateRobotMapCommand updateRobotMapCommand;
    Preferences robotPreferences;

    @Override
    public void robotInit() {
        updatePreferences();
        driveTrain = new DriveTrain();
        // gyro = new Gyro();
        // driveEncoder = new DriveEncoder();
        // arm = new Arm();
        oi = new OI();
        // autonomousCommand = new AutoScoreCloseSwitch();
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
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

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