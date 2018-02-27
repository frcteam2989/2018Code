package frc.team2989.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.subsystems.Potentiometer;

public class SetWristCommand extends Command {

    Potentiometer potentiometer;
    boolean firstPotentiometer;
    double difference;
    double initialValue;
    double finalValue;
    double motorSpeed;

    public SetWristCommand(double finalPotentiometerValue, boolean firstPotentiometer) {
        this.firstPotentiometer = firstPotentiometer;
        this.potentiometer = (firstPotentiometer) ? Robot.wristPotentiometer : Robot.secondPotentiometer;
        this.finalValue = finalPotentiometerValue;
        requires(potentiometer);
        requires(Robot.arm);
    }

    @Override
    protected void initialize() {
        this.initialValue = potentiometer.get();

        this.difference = initialValue - finalValue;

        // Pot 1 over a certain value, fast otherwise slow
        this.motorSpeed = (difference < 0) ? RobotMap.ARM_WRIST_SPEED_FAST : RobotMap.ARM_WRIST_SPEED_SLOW;
        output(difference);
        applyPotentiometerSpeed(initialValue);
    }

    @Override
    protected void execute() {
        applyPotentiometerSpeed(potentiometer.get());
        SmartDashboard.putNumber("Arm movement speed (non direction biased)", motorSpeed);
    }

    @Override
    protected boolean isFinished() {
        double currentAngle = potentiometer.get();
        double currentDifference = currentAngle - finalValue;
        output(currentDifference);
        if(difference > 0) {
            return currentDifference <= 0;
        } else {
            return currentDifference >= 0;
        }
    }

    @Override
    protected void end() {
        Robot.arm.setWristSpeed(0);
        SmartDashboard.putNumber("Arm movement speed (non direction biased)", 0);
    }

    @Override
    protected void interrupted() {
        Robot.arm.setWristSpeed(0);
        SmartDashboard.putNumber("Arm movement speed (non direction biased)", 0);
    }

    private void applyPotentiometerSpeed(double potentiometerValue) {
        if(firstPotentiometer) {
            if(difference > 0) {
                Robot.arm.setWristSpeed(getSpeed(false, potentiometerValue));
            } else {
                Robot.arm.setWristSpeed(getSpeed(true, potentiometerValue));
            }
        } else {
            if(difference > 0) {
                Robot.arm.setWristSpeed(getSpeed(true, potentiometerValue));
            } else {
                Robot.arm.setWristSpeed(getSpeed(false, potentiometerValue));
            }
        }
    }

    private double getSpeed(boolean forwards, double potentiometerValue) {
        double vertValue;
        double currentSpeed;
        double slowSpeed = RobotMap.ARM_WRIST_SPEED_SLOW;
        double fastSpeed = RobotMap.ARM_WRIST_SPEED_FAST;
        if(firstPotentiometer) {
            vertValue = RobotMap.ARM_POTENTIOMETER_1_VERT_VALUE;
            currentSpeed = ((potentiometerValue >= 0) && (potentiometerValue <= vertValue)) ? (!forwards ? slowSpeed : fastSpeed) : (!forwards ? fastSpeed : slowSpeed);
        } else {
            vertValue = RobotMap.ARM_POTENTIOMETER_2_VERT_VALUE;
            currentSpeed = ((potentiometerValue >= 0) && (potentiometerValue <= vertValue)) ? (forwards ? slowSpeed : fastSpeed) : (forwards ? fastSpeed : slowSpeed);
        }
        return currentSpeed * (forwards ? 1 : -1);
    }

    private void output(double currentDistance) {
        /*System.out.print("Potentiometer: " + potentiometer.get());
        System.out.print("Initial Value: " + initialValue);
        System.out.print("Final Value:" + finalValue);
        System.out.println("Initial Distance: " + difference);
        System.out.println("Current Distance: " + currentDistance);
        System.out.println("Potentiometer:" + potentiometer.getName());
        System.out.println("Speed: " + Robot.arm.getWristSpeed());*/
    }

}
