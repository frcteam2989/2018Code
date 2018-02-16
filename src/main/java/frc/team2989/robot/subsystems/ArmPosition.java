package frc.team2989.robot.subsystems;

public enum ArmPosition {

    INTAKE(45, 45),
    REST(116.62917, 180),
    OUTTAKE(90, 90),
    TEST(80, 170);


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
