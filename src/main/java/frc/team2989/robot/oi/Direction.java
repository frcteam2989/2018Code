package frc.team2989.robot.oi;

public enum Direction {

    FORWARD,
    REVERSE,
    STOPPED;

    public static Direction fromTriggers(double leftTrigger, double rightTrigger) {
        boolean isReverse = leftTrigger <= 0;
        boolean isForward = rightTrigger <= 0;
        if(isReverse && isForward || (!isReverse && !isForward)) {
            return STOPPED;
        }
        return (isReverse) ? REVERSE : FORWARD;
    }

    public static double applyDirection(double speed, Direction direction) {
        return (direction == FORWARD) ? speed * 1 : speed * -1;
    }
}
