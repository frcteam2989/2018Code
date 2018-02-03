package frc.team2989.robot.oi;

public enum DriveDirection {

    FORWARD,
    REVERSE,
    STOPPED;

    public static DriveDirection fromTriggers(double leftTrigger, double rightTrigger) {
        boolean isReverse = leftTrigger <= 0;
        boolean isForward = rightTrigger <= 0;
        if(isReverse && isForward) {
            return STOPPED;
        }
        if(!isReverse && !isForward) {
            return STOPPED;
        }
        if(isReverse) {
            return REVERSE;
        }
        return FORWARD;
    }
}
