package frc.team2989.robot.subsystems;

import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.commands.SetWristCommand;

public enum ArmPosition {

    STARTING_FRONT(.2694565, false, IntakeDirection.INTAKE),
    STARTING_BACK(.29124314241886606, true, IntakeDirection.OUTTAKE),
    INTAKE(.2125, true, IntakeDirection.INTAKE),
    PORTAL(.2575511, false, IntakeDirection.INTAKE),
    EXCHANGE(.1696136, false, IntakeDirection.INTAKE),
    SHOOT_BACK(.2743367193044849, false, IntakeDirection.OUTTAKE),
    SHOOT_FORWARD(.316586890215012, true, IntakeDirection.INTAKE),
    POT2_VERT(.3345444802608088, false, IntakeDirection.OUTTAKE);



    private double potentiometerAngle;
    private boolean firstPotentiometer;
    private IntakeDirection elbowPosition;

    ArmPosition(double potentiometerAngle, boolean firstPotentiometer, IntakeDirection elbowPosition) {
        this.potentiometerAngle = potentiometerAngle;
        this.firstPotentiometer = firstPotentiometer;
        this.elbowPosition = elbowPosition;
    }

    public static SetWristCommand getByPosition(ArmPosition position) {
        return new SetWristCommand(position.getAngle(), position.useFirstPotentiometer());
    }

    public double getAngle() {
        return potentiometerAngle;
    }

    public boolean useFirstPotentiometer() {
        return firstPotentiometer;
    }

    public IntakeDirection getDirection() {
        return elbowPosition;
    }
}
