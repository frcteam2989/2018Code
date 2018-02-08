package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;

public class Intake extends Subsystem {

    private SpeedControllerGroup intakeTalons;

    public Intake() {
        intakeTalons = new SpeedControllerGroup(new PWMTalonSRX(RobotMap.INTAKE_LEFT_PORT), new PWMTalonSRX(RobotMap.INTAKE_RIGHT_PORT));
    }

    @Override
    public void initDefaultCommand() {

    }

    public void setMotorSpeed(double speed, Direction direction) {
        intakeTalons.set(Direction.applyDirection(speed, direction));
    }

    public void stopMotor() {
        intakeTalons.set(0);
    }

    public enum Direction {
        INTAKE,
        OUTTAKE;

        public static double applyDirection(double speed, Direction direction) {
            double directionFactor = (direction == OUTTAKE) ? 1 : -1;
            return Math.abs(speed) * directionFactor;
        }

    }
}
