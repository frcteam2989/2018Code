package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.RobotMap;

public class Intake extends Subsystem {

    private SpeedControllerGroup intakeTalons;

    public Intake() {
        intakeTalons = new SpeedControllerGroup(new PWMTalonSRX(RobotMap.INTAKE_PORT));
    }

    @Override
    public void initDefaultCommand() {

    }

    public void setMotorSpeed(double speed, IntakeDirection direction) {
        intakeTalons.set(IntakeDirection.applyDirection(speed, direction)*-1);
    }

    public void stopMotor() {
        intakeTalons.set(0);
    }

}
