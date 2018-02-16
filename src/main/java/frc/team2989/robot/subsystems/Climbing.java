package frc.team2989.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2989.robot.RobotMap;

public class Climbing extends Subsystem {

    SpeedControllerGroup climbMotors;
    SpeedController tapeMeasureMotor;

    public Climbing() {
        this.climbMotors = new SpeedControllerGroup(new Victor(RobotMap.CLIMBING_GEARBOX_1), new Victor(RobotMap.CLIMBING_GEARBOX_2));
        this.tapeMeasureMotor = new Victor(RobotMap.CLIMBING_TAPE_MEASURE);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void setGearboxSpeed(double speed) {
        climbMotors.set(speed);
    }

    public void setTapeMeasureSpeed(double speed) {
        climbMotors.set(speed);
    }
}
