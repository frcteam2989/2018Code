package frc.team2989.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotMap {

    // Default constants
    // To add one, add the default here and add it under the update() method.

    // Motors
    public static int MOTOR_DRIVE_LEFT = 0;
    public static int MOTOR_DRIVE_RIGHT = 1;

    // Operator Interface
    public static int JOYSTICK_DRIVE_PORT = 1;
    public static int JOYSTICK_DRIVE_LEFT_X = 0;
    public static int JOYSTICK_DRIVE_LEFT_Y = 1;
    public static int JOYSTICK_DRIVE_RIGHT_X = 4;
    public static int JOYSTICK_DRIVE_RIGHT_Y = 5;
    public static int JOYSTICK_DRIVE_LEFT_TRIGGER = 2;
    public static int JOYSTICK_DRIVE_RIGHT_TRIGGER = 3;

    public static int JOYSTICK_ARM_PORT = 0;
    public static int JOYSTICK_ARM_X = 0;
    public static int JOYSTICK_ARM_Y = 1;
    public static int JOYSTICK_ARM_BUTTON_1 = 0;
    public static int JOYSTICK_ARM_BUTTON_2 = 1;
    public static int JOYSTICK_ARM_BUTTON_3 = 2;
    public static int JOYSTICK_ARM_BUTTON_4 = 3;
    public static int JOYSTICK_ARM_BUTTON_5 = 4;

    // Arm
    public static int ARM_ELBOW_POTENTIOMETER_PORT = 0;
    public static int ARM_WRIST_POTENTIOMETER_PORT = 1;
    public static double ARM_ELBOW_POTENTIOMETER_OFFSET = .49;
    public static double ARM_WRIST_POTENTIOMETER_OFFSET = .32;
    public static double ARM_ANGLE_DEVIATION = 1;
    public static double ARM_MOVEMENT_SPEED = .25;

    // Sensors
    public static int SENSORS_GYRO_PORT = 1;
    public static int SENSORS_ENCODER_DRIVE_PORT1 = 2;
    public static int SENSORS_ENCODER_DRIVE_PORT2 = 3;
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

    // FAR Delivery
    // (Delivery Scenario #2)

    // Drive
    public static double AUTONOMOUS_FAR_DRIVE_SPEED = 1;
    public static double AUTONOMOUS_FAR_DRIVE_ROTATION = 0;
    public static double AUTONOMOUS_FAR_DRIVE_DISTANCE = 571.5;
    public static double AUTONOMOUS_FAR_DRIVE_DEVIATION = 1;

    // Turn
    public static double AUTONOMOUS_FAR_TURN_SPEED = 0.5;
    public static double AUTONOMOUS_FAR_TURN_ROTATION = 90;
    public static double AUTONOMOUS_FAR_TURN_ANGLE = 90;
    public static double AUTONOMOUS_FAR_TURN_DEVIATION = 5;

    // Drive Past
    public static double AUTONOMOUS_FAR_DRIVE_PAST_SPEED = 1;
    public static double AUTONOMOUS_FAR_DRIVE_PAST_ROTATION = 0;
    public static double AUTONOMOUS_FAR_DRIVE_PAST_DISTANCE = 635.254;
    public static double AUTONOMOUS_FAR_DRIVE_PAST_DEVIATION = 1;

    // Turn past
    public static double AUTONOMOUS_FAR_TURN_PAST_SPEED = 0.5;
    public static double AUTONOMOUS_FAR_TURN_PAST_ROTATION = 90;
    public static double AUTONOMOUS_FAR_TURN_PAST_ANGLE = 90;
    public static double AUTONOMOUS_FAR_TURN_PAST_DEVIATION = 5;

    // Drive To
    public static double AUTONOMOUS_FAR_DRIVE_TO_SPEED = 1;
    public static double AUTONOMOUS_FAR_DRIVE_TO_ROTATION = 0;
    public static double AUTONOMOUS_FAR_DRIVE_TO_DISTANCE = 136.652;
    public static double AUTONOMOUS_FAR_DRIVE_TO_DEVIATION = 1;

    // Turn past
    public static double AUTONOMOUS_FAR_TURN_TO_SPEED = 0.5;
    public static double AUTONOMOUS_FAR_TURN_TO_ROTATION = 90;
    public static double AUTONOMOUS_FAR_TURN_TO_ANGLE = 90;
    public static double AUTONOMOUS_FAR_TURN_TO_DEVIATION = 5;

    // Drive into
    public static double AUTONOMOUS_FAR_DRIVE_INTO_SPEED = 1;
    public static double AUTONOMOUS_FAR_DRIVE_INTO_ROTATION = 0;
    public static double AUTONOMOUS_FAR_DRIVE_INTO_DISTANCE = 80.01;
    public static double AUTONOMOUS_FAR_DRIVE_INTO_DEVIATION = 1;
    
    // Launch
    public static double AUTONOMOUS_FAR_LAUNCH_SPEED = 0.1;

    // Far Delivery
    // (Delivery Scenario #2)

    // Turn Past Phase
    public static double AUTONOMOUS_TURN_PAST_SPEED = 0.5;
    public static double AUTONOMOUS_TURN_PAST_ROTATION = 90;
    public static double AUTONOMOUS_TURN_PAST_ANGLE = 90;
    public static double AUTONOMOUS_TURN_PAST_DEVIATION = 5;

    // Arm
    public static int ARM_ELBOW_PORT = 2;
    public static int ARM_WRIST_PORT = 3;

    // Intake
    public static int INTAKE_PORT = 4;
    public static double INTAKE_SPEED = 0.1;
    public static double INTAKE_SHUTOFF_DISTANCE = 2;
    public static int INTAKE_ULTRASONIC_PORT = 4;
    public static double INTAKE_CUBE_DEVIATION = 2;
    public static double INTAKE_CUBE_DISTANCE = .25;

    // Climbing
    public static int CLIMBING_GEARBOX_1 = 5;
    public static int CLIMBING_GEARBOX_2 = 6;
    public static int CLIMBING_TAPE_MEASURE = 7;

    // Potentiometer Constants
    public static double POTENTIOMETER_WRIST_FIRST_ANGLE_LENGTH = .17;
    public static double POTENTIOMETER_WRIST_SECOND_ANGLE_LENGTH = .135;
    public static double POTENTIOMETER_ELBOW_FIRST_ANGLE_LENGTH = .28;
    public static double POTENTIOMETER_ELBOW_SECOND_ANGLE_LENGTH = .3;
    public static double POTENTIOMETER_TOTAL_DISTANCE = .69;

    // End default constants

    // Called periodically from preferences command to update values so that we don't have to reboot for the constants to change
    public static synchronized void update() {
        Preferences prefs = Preferences.getInstance();

        // Update Arm
        ARM_ELBOW_POTENTIOMETER_PORT = prefs.getInt("Elbow Potentiometer Port", ARM_ELBOW_POTENTIOMETER_PORT);
        ARM_WRIST_POTENTIOMETER_PORT = prefs.getInt("Wrist Potentiometer Port", ARM_WRIST_POTENTIOMETER_PORT);
        ARM_ELBOW_POTENTIOMETER_OFFSET = prefs.getDouble("Elbow Potentiometer Port", ARM_ELBOW_POTENTIOMETER_OFFSET);
        ARM_WRIST_POTENTIOMETER_OFFSET = prefs.getDouble("Wrist Potentiometer Port", ARM_WRIST_POTENTIOMETER_OFFSET);
        ARM_ANGLE_DEVIATION = prefs.getDouble("Arm Angle Deviation", ARM_ANGLE_DEVIATION);
        ARM_MOVEMENT_SPEED = prefs.getDouble("Arm Movement Speed", ARM_MOVEMENT_SPEED);

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

        // FAR Delivery
        // (Delivery Scenario #2)

        // Drive
        AUTONOMOUS_FAR_DRIVE_SPEED = prefs.getDouble("Autonomous far drive speed", AUTONOMOUS_FAR_DRIVE_SPEED);
        AUTONOMOUS_FAR_DRIVE_ROTATION = prefs.getDouble("Autonomous far drive rotation", AUTONOMOUS_FAR_DRIVE_ROTATION);
        AUTONOMOUS_FAR_DRIVE_DISTANCE = prefs.getDouble("Autonomous far drive distance", AUTONOMOUS_FAR_DRIVE_DISTANCE);
        AUTONOMOUS_FAR_DRIVE_DEVIATION = prefs.getDouble("Autonomous far drive deviation", AUTONOMOUS_FAR_DRIVE_DEVIATION);

        // Turn
        AUTONOMOUS_FAR_TURN_SPEED = prefs.getDouble("Autonomous far turn speed", AUTONOMOUS_FAR_TURN_SPEED);
        AUTONOMOUS_FAR_TURN_ROTATION = prefs.getDouble("Autonomous far turn rotation", AUTONOMOUS_FAR_TURN_ROTATION);
        AUTONOMOUS_FAR_TURN_ANGLE = prefs.getDouble("Autonomous far turn angle", AUTONOMOUS_FAR_TURN_ANGLE);
        AUTONOMOUS_FAR_TURN_DEVIATION = prefs.getDouble("Autonomous far turn deviation", AUTONOMOUS_FAR_TURN_DEVIATION);

        // Drive Past
        AUTONOMOUS_FAR_DRIVE_PAST_SPEED = prefs.getDouble("Autonomous far drive past speed", AUTONOMOUS_FAR_DRIVE_PAST_SPEED);
        AUTONOMOUS_FAR_DRIVE_PAST_ROTATION = prefs.getDouble("Autonomous far drive past rotation", AUTONOMOUS_FAR_DRIVE_PAST_ROTATION);
        AUTONOMOUS_FAR_DRIVE_PAST_DISTANCE = prefs.getDouble("Autonomous far drive past distance", AUTONOMOUS_FAR_DRIVE_PAST_DISTANCE);
        AUTONOMOUS_FAR_DRIVE_PAST_DEVIATION = prefs.getDouble("Autonomous far drive past ", AUTONOMOUS_FAR_DRIVE_PAST_DEVIATION);

        // Turn past
        AUTONOMOUS_FAR_TURN_PAST_SPEED = prefs.getDouble("Autonomous far turn past speed", AUTONOMOUS_FAR_TURN_PAST_SPEED);
        AUTONOMOUS_FAR_TURN_PAST_ROTATION = prefs.getDouble("Autonomous far turn past rotation", AUTONOMOUS_FAR_TURN_PAST_ROTATION);
        AUTONOMOUS_FAR_TURN_PAST_ANGLE = prefs.getDouble("Autonomous far turn past angle", AUTONOMOUS_FAR_TURN_PAST_ANGLE);
        AUTONOMOUS_FAR_TURN_PAST_DEVIATION = prefs.getDouble("Autonomous far turn past deviation", AUTONOMOUS_FAR_TURN_PAST_DEVIATION);

        // Drive To
        AUTONOMOUS_FAR_DRIVE_TO_SPEED = prefs.getDouble("Autonomous far drive to speed", AUTONOMOUS_FAR_DRIVE_TO_SPEED);
        AUTONOMOUS_FAR_DRIVE_TO_ROTATION = prefs.getDouble("Autonomous far drive to rotation", AUTONOMOUS_FAR_DRIVE_TO_ROTATION);
        AUTONOMOUS_FAR_DRIVE_TO_DISTANCE = prefs.getDouble("Autonomous far drive to distance", AUTONOMOUS_FAR_DRIVE_TO_DISTANCE);
        AUTONOMOUS_FAR_DRIVE_TO_DEVIATION = prefs.getDouble("Autonomous far drive to deviation", AUTONOMOUS_FAR_DRIVE_TO_DEVIATION);

        // Turn past
        AUTONOMOUS_FAR_TURN_TO_SPEED = prefs.getDouble("Autonomous far turn to speed", AUTONOMOUS_FAR_TURN_TO_SPEED);
        AUTONOMOUS_FAR_TURN_TO_ROTATION = prefs.getDouble("Autonomous far turn to rotation", AUTONOMOUS_FAR_TURN_TO_ROTATION);
        AUTONOMOUS_FAR_TURN_TO_ANGLE = prefs.getDouble("Autonomous far turn to angle", AUTONOMOUS_FAR_TURN_TO_ANGLE);
        AUTONOMOUS_FAR_TURN_TO_DEVIATION = prefs.getDouble("Autonomous far turn to deviation", AUTONOMOUS_FAR_TURN_TO_DEVIATION);

        // Drive into
        AUTONOMOUS_FAR_DRIVE_INTO_SPEED = prefs.getDouble("Autonomous far drive into speed", AUTONOMOUS_FAR_DRIVE_INTO_SPEED);
        AUTONOMOUS_FAR_DRIVE_INTO_ROTATION = prefs.getDouble("Autonomous far drive into rotation", AUTONOMOUS_FAR_DRIVE_INTO_ROTATION);
        AUTONOMOUS_FAR_DRIVE_INTO_DISTANCE = prefs.getDouble("Autonomous far drive into distance", AUTONOMOUS_FAR_DRIVE_INTO_DISTANCE);
        AUTONOMOUS_FAR_DRIVE_INTO_DEVIATION = prefs.getDouble("Autonomous far drive into deviation", AUTONOMOUS_FAR_DRIVE_INTO_DEVIATION);

        // Launch
        AUTONOMOUS_FAR_LAUNCH_SPEED = prefs.getDouble("Autonomous Far Launch Sspeed", AUTONOMOUS_FAR_LAUNCH_SPEED);


        // Update Arm
        ARM_ELBOW_PORT = prefs.getInt("Left Arm Speed Controller Port", ARM_ELBOW_PORT);
        ARM_WRIST_PORT = prefs.getInt("Right Arm Speed Controller Port", ARM_WRIST_PORT);

        // Update Intake
        INTAKE_PORT = prefs.getInt("Intake Speed Controller Port", INTAKE_PORT);
        INTAKE_SPEED = prefs.getDouble("Intake Speed", INTAKE_SPEED);
        INTAKE_SHUTOFF_DISTANCE = prefs.getDouble("Intake Shutoff Distance (in)", INTAKE_SHUTOFF_DISTANCE);
        INTAKE_ULTRASONIC_PORT = prefs.getInt("Intake Ultrasonic Sensor Port", INTAKE_ULTRASONIC_PORT);
        INTAKE_CUBE_DEVIATION = prefs.getDouble("Intake Ultrasonic Cube Deviation", INTAKE_CUBE_DEVIATION);
        INTAKE_CUBE_DISTANCE = prefs.getDouble("Intake Ultrasonic Cube Distance", INTAKE_CUBE_DISTANCE);

        // Update Climbing
        CLIMBING_GEARBOX_1 = prefs.getInt("Climbing Gearbox Port 1", CLIMBING_GEARBOX_1);
        CLIMBING_GEARBOX_2 = prefs.getInt("Climbing Gearbox Port 2", CLIMBING_GEARBOX_2);
        CLIMBING_TAPE_MEASURE = prefs.getInt("Climbing Tape Measure Port", CLIMBING_TAPE_MEASURE);

        // Potentiometer Angle Values (m)
        POTENTIOMETER_WRIST_FIRST_ANGLE_LENGTH = prefs.getDouble("Wrist Potentiometer First Angle Length", POTENTIOMETER_WRIST_FIRST_ANGLE_LENGTH);
        POTENTIOMETER_WRIST_SECOND_ANGLE_LENGTH = prefs.getDouble("Wrist Potentiometer Second Angle Length", POTENTIOMETER_WRIST_SECOND_ANGLE_LENGTH);
        
        POTENTIOMETER_ELBOW_FIRST_ANGLE_LENGTH = prefs.getDouble("Elbow Potentiometer First Angle Length", POTENTIOMETER_ELBOW_FIRST_ANGLE_LENGTH);
        POTENTIOMETER_ELBOW_SECOND_ANGLE_LENGTH = prefs.getDouble("Elbow Potentiometer Second Angle Length", POTENTIOMETER_ELBOW_SECOND_ANGLE_LENGTH);

        POTENTIOMETER_TOTAL_DISTANCE = prefs.getDouble("Potentiometer Total Distance", POTENTIOMETER_TOTAL_DISTANCE);
    }
}
