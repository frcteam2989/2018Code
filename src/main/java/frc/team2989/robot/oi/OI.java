package frc.team2989.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team2989.robot.IntakeDirection;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.*;
import frc.team2989.robot.subsystems.ArmPosition;

public class OI {

    Joystick driveStick;
    Joystick armStick;

    Button button6;
    Button button7;
    Button elbowUp;
    Button intake;
    Button outtakeSlow;
    Button outtakeShoot;
    Button shootBackButton;
    Button exchangeButton;
    Button armTrigger;
    Button forwardElbow;
    Button preIntake;

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
        button7 = new JoystickButton(armStick, RobotMap.JOYSTICK_ELBOW_DOWN_BUTTON);
        elbowUp = new JoystickButton(armStick, RobotMap.JOYSTICK_ELBOW_UP_BUTTON);
        intake = new JoystickButton(armStick, RobotMap.JOYSTICK_INTAKE_BUTTON);
        outtakeSlow = new JoystickButton(armStick, RobotMap.JOYSTICK_OUTTAKE_SLOW_BUTTON);
        outtakeShoot = new JoystickButton(armStick, RobotMap.JOYSTICK_OUTTAKE_SHOOT_BUTTON);
        shootBackButton = new JoystickButton(armStick, RobotMap.JOYSTICK_SHOOT_BACK_BUTTON);
        exchangeButton = new JoystickButton(armStick, RobotMap.JOYSTICK_EXCHANGE_BUTTON);
        forwardElbow = new JoystickButton(armStick, 8);
        preIntake = new JoystickButton(armStick, 9);
        button6 = new JoystickButton(armStick, 6);

        button6.whileHeld(ArmPosition.getByPosition(ArmPosition.STARTING_FRONT));
        button7.whileHeld(ArmPosition.getByPosition(ArmPosition.SHOOT_FORWARD));
        shootBackButton.whileHeld(ArmPosition.getByPosition(ArmPosition.SHOOT_BACK));
        exchangeButton.whileHeld(ArmPosition.getByPosition(ArmPosition.EXCHANGE));

        elbowUp.whileHeld(new SetArmCommandGroup(ArmPosition.INTAKE)); // Quick Intake
        preIntake.whileHeld(ArmPosition.getByPosition(ArmPosition.POT2_VERT));

        intake.whileHeld(new IntakeSpinCommand(IntakeDirection.INTAKE, RobotMap.INTAKE_SPEED));
        outtakeSlow.whileHeld(new IntakeSpinCommand(IntakeDirection.OUTTAKE, RobotMap.INTAKE_SPEED));
        outtakeShoot.whileHeld(new IntakeSpinCommand(IntakeDirection.OUTTAKE, 1));
    }

    public Button getArmTrigger() {
        return armTrigger;
    }

    public boolean climbTapeMeasurePressed() {
        return shootBackButton.get();
    }
}
