package frc.team2989.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.ClimbCommand;
import frc.team2989.robot.commands.IntakeSpinCommand;
import frc.team2989.robot.commands.SetElbowCommand;
import frc.team2989.robot.subsystems.ArmPosition;
import frc.team2989.robot.subsystems.Climbing;

public class OI {

    Joystick driveStick;
    Joystick armStick;

    Button elbowDown;
    Button elbowUp;
    Button intake;
    Button outtakeSlow;
    Button outtakeShoot;
    Button climbTapeMeasure;
    Button climbMotor;
    Button armTrigger;
    Button forwardElbow;
    Button backwardElbow;

    // GTADrive drive;

    public OI() {
        super();
        driveStick = new Joystick(RobotMap.JOYSTICK_DRIVE_PORT);
        loadArmController();
       //  drive = new GTADrive(driveStick);
    }

    public Joystick getDriveStick() {
        return driveStick;
    }

    public Joystick getArmStick() { return armStick; }

    public void loadArmController() {
        // 7 8 2 4 5 10 11
        armStick = new Joystick(RobotMap.JOYSTICK_ARM_PORT);
        armTrigger = new JoystickButton(armStick, RobotMap.JOYSTICK_TRIGGER_BUTTON);
        elbowDown = new JoystickButton(armStick, RobotMap.JOYSTICK_ELBOW_DOWN_BUTTON);
        elbowUp = new JoystickButton(armStick, RobotMap.JOYSTICK_ELBOW_UP_BUTTON);
        intake = new JoystickButton(armStick, RobotMap.JOYSTICK_INTAKE_BUTTON);
        outtakeSlow = new JoystickButton(armStick, RobotMap.JOYSTICK_OUTTAKE_SLOW_BUTTON);
        outtakeShoot = new JoystickButton(armStick, RobotMap.JOYSTICK_OUTTAKE_SHOOT_BUTTON);
        climbTapeMeasure = new JoystickButton(armStick, RobotMap.JOYSTICK_CLIMB_TAPE_MEASURE_BUTTON);
        climbMotor = new JoystickButton(armStick, RobotMap.JOYSTICK_CLIMB_MOTOR_BUTTON);
        forwardElbow = new JoystickButton(armStick, 8);
        backwardElbow = new JoystickButton(armStick, 9);

        elbowDown.whenReleased(ArmPosition.getByPosition(ArmPosition.STARTING_BACK));
        elbowUp.whenReleased(ArmPosition.getByPosition(ArmPosition.INTAKE));
        forwardElbow.whileHeld(new SetElbowCommand(IntakeDirection.INTAKE, .1));
        backwardElbow.whileHeld(new SetElbowCommand(IntakeDirection.OUTTAKE, .1));
        intake.whileHeld(new IntakeSpinCommand(IntakeDirection.INTAKE, RobotMap.INTAKE_SPEED));
        outtakeSlow.whileHeld(new IntakeSpinCommand(IntakeDirection.OUTTAKE, RobotMap.INTAKE_SPEED));
        outtakeShoot.whileHeld(new IntakeSpinCommand(IntakeDirection.OUTTAKE, 1));
        climbMotor.whileHeld(new ClimbCommand());

    }

    public Button getArmTrigger() {
        return armTrigger;
    }

    public boolean climbTapeMeasurePressed() {
        return climbTapeMeasure.get();
    }
}
