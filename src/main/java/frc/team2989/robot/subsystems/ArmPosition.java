package frc.team2989.robot.subsystems;

public enum ArmPosition {

    INTAKE(45, 45),
    OUTTAKE(90, 90);


    private double elbowAngle;
    private double wristAngle;

    ArmPosition(double elbowAngle, double wristAngle) {
        this.elbowAngle = elbowAngle;
        this.wristAngle = wristAngle;
    }

    public double getElbowAngle() {
        return elbowAngle;
    }

    public double getWristAngle() {
        return wristAngle;
    }
}
