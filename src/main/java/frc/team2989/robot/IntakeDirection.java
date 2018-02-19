package frc.team2989.robot;

public enum IntakeDirection {
    INTAKE, // Down
    OUTTAKE; // Up

    public static double applyDirection(double speed, IntakeDirection direction) {
        double directionFactor = (direction == INTAKE) ? 1 : -1;
        return Math.abs(speed) * directionFactor;
    }

}