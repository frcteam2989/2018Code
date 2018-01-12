package frc.team2989.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotMap {

    // Default constants
    // To add one, add the default here and add it under the update() method.

    // Motors
    public static int MOTOR_DRIVE_LEFT = 0;
    public static int MOTOR_DRIVE_RIGHT = 1;

    // Operator Interface
    public static int JOYSTICK_DRIVE_PORT = 0;
    public static int JOYSTICK_DRIVE_LEFT_X = 0;
    public static int JOYSTICK_DRIVE_LEFT_Y = 1;
    public static int JOYSTICK_DRIVE_RIGHT_X = 4;
    public static int JOYSTICK_DRIVE_RIGHT_Y = 5;

    // Sensors
    public static int SENSORS_GYRO_PORT = 1;
    public static int SENSORS_ENCODER_DRIVE_PORT1 = 0;
    public static int SENSORS_ENCODER_DRIVE_PORT2 = 1;
    public static int SENSORS_ENCODER_DRIVE_DISTANCE_PER_PULSE = 5;

    // Autonomous

    // Close Delivery
    // (Delivery Scenario #1)

    // Drive
    public static double AUTONOMOUS_CLOSE_DRIVE_SPEED = 1;
    public static double AUTONOMOUS_CLOSE_DRIVE_ROTATION = 0;
    public static double AUTONOMOUS_CLOSE_DRIVE_DISTANCE = 310.65;
    public static double AUTONOMOUS_CLOSE_DRIVE_DEVIATION = 1;

    // Turn
    public static double AUTONOMOUS_CLOSE_TURN_SPEED = 0.5;
    public static double AUTONOMOUS_CLOSE_TURN_ROTATION = 90;
    public static double AUTONOMOUS_CLOSE_TURN_ANGLE = 90;
    public static double AUTONOMOUS_CLOSE_TURN_DEVIATION = 5;

    // Launch
    public static double AUTONOMOUS_CLOSE_LAUNCH_SPEED = 0.1;

    // Far Delivery
    // (Delivery Scenario #2)

    // Turn Past Phase
    public static double AUTONOMOUS_TURN_PAST_SPEED = 0.5;
    public static double AUTONOMOUS_TURN_PAST_ROTATION = 90;
    public static double AUTONOMOUS_TURN_PAST_ANGLE = 90;
    public static double AUTONOMOUS_TURN_PAST_DEVIATION = 5;

    // End default constants

    // Called periodically from preferences command to update values so that we don't have to reboot for the constants to change
    public static void update() {
        Preferences prefs = Preferences.getInstance();

        // Update motors
        MOTOR_DRIVE_LEFT = prefs.getInt("Left Drive Motor PWM Port", MOTOR_DRIVE_LEFT);
        MOTOR_DRIVE_RIGHT = prefs.getInt("Right Drive Motor PWM Port", MOTOR_DRIVE_RIGHT);

        // Update Operator Interface
        JOYSTICK_DRIVE_PORT = prefs.getInt("Drive Joystick Port", JOYSTICK_DRIVE_PORT);
        JOYSTICK_DRIVE_LEFT_X = prefs.getInt("Drive Joystick Left X Axis", JOYSTICK_DRIVE_LEFT_X);
        JOYSTICK_DRIVE_LEFT_Y = prefs.getInt("Drive Joystick Left Y Axis", JOYSTICK_DRIVE_LEFT_Y);
        JOYSTICK_DRIVE_RIGHT_X = prefs.getInt("Drive Joystick Right X Axis", JOYSTICK_DRIVE_RIGHT_X);
        JOYSTICK_DRIVE_RIGHT_Y = prefs.getInt("Drive Joystick Right Y Axis", JOYSTICK_DRIVE_RIGHT_Y);

        // Update Sensors
        SENSORS_GYRO_PORT = prefs.getInt("Gyro Sensor Port", SENSORS_GYRO_PORT);
        SENSORS_ENCODER_DRIVE_PORT1 = prefs.getInt("Encoder Sensor Analog Port (1)", SENSORS_ENCODER_DRIVE_PORT1);
        SENSORS_ENCODER_DRIVE_PORT2 = prefs.getInt("Encoder Sensor Analog Port (2)", SENSORS_ENCODER_DRIVE_PORT2);
        SENSORS_ENCODER_DRIVE_DISTANCE_PER_PULSE = prefs.getInt("Encoder Sensor Distance Per Rotation (cm)", SENSORS_ENCODER_DRIVE_DISTANCE_PER_PULSE);

        // Autonomous:

        // Close Delivery
        // (Delivery Scenario #1)

        // Drive
        AUTONOMOUS_CLOSE_DRIVE_DISTANCE = prefs.getDouble("Auto Close Drive Stage 1 Distance (cm)", AUTONOMOUS_CLOSE_DRIVE_DISTANCE);
        AUTONOMOUS_CLOSE_DRIVE_DEVIATION = prefs.getDouble("Auto Close Drive Stage 1 Deviation (cm)", AUTONOMOUS_CLOSE_DRIVE_DEVIATION);

        // Turn
        AUTONOMOUS_CLOSE_TURN_SPEED = prefs.getDouble("Autonomous Turn Stage Speed (-1 to 1)", AUTONOMOUS_CLOSE_TURN_SPEED);
        AUTONOMOUS_CLOSE_TURN_ROTATION = prefs.getDouble("Autonomous Turn Stage Rotation (angle)", AUTONOMOUS_CLOSE_TURN_ROTATION);
        AUTONOMOUS_CLOSE_TURN_ANGLE = prefs.getDouble("Autonomous Turn Stage Desired Angle", AUTONOMOUS_CLOSE_TURN_ANGLE);
        AUTONOMOUS_CLOSE_TURN_DEVIATION = prefs.getDouble("Autonomous Turn Stage Deviation (angle)", AUTONOMOUS_CLOSE_TURN_DEVIATION);

        // Launch
        AUTONOMOUS_CLOSE_LAUNCH_SPEED = prefs.getDouble("Autonomous Close Drive Launch Speed (cm)", AUTONOMOUS_CLOSE_LAUNCH_SPEED);

        // Far Delivery
        // (Delivery Scenario #2)

        // Update Turn Phase
        AUTONOMOUS_TURN_PAST_SPEED = prefs.getDouble("Autonomous Turn Past Stage Speed (-1 to 1)", AUTONOMOUS_TURN_PAST_SPEED);
        AUTONOMOUS_TURN_PAST_ROTATION = prefs.getDouble("Autonomous Turn Past Stage Rotation (angle)", AUTONOMOUS_TURN_PAST_ROTATION);
        AUTONOMOUS_TURN_PAST_ANGLE = prefs.getDouble("Autonomous Turn Past Stage Desired Angle", AUTONOMOUS_TURN_PAST_ANGLE);
        AUTONOMOUS_TURN_PAST_DEVIATION = prefs.getDouble("Autonomous Turn Past Stage Deviation (angle)", AUTONOMOUS_TURN_PAST_DEVIATION);
    }
}
