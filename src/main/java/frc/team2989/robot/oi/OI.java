package frc.team2989.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team2989.robot.Robot;
import frc.team2989.robot.RobotMap;
import frc.team2989.robot.commands.IntakeSpinCommand;
import frc.team2989.robot.commands.SetArmCommand;
import frc.team2989.robot.commands.TestArmCommand;
import frc.team2989.robot.commands.commandgroups.SetArmCommandGroup;
import frc.team2989.robot.subsystems.ArmPosition;
import frc.team2989.robot.subsystems.Intake;

import java.util.stream.Stream;

public class OI {

    Joystick driveStick;
    Joystick armStick;

    Button armTrigger;
    Button arm2;
    Button arm3;
    Button arm4;
    Button arm5;
    Button arm10;
    Button arm11;
    Button arm6;

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
        armStick = new Joystick(RobotMap.JOYSTICK_ARM_PORT);
        /*armTrigger = new JoystickButton(armStick, RobotMap.JOYSTICK_ARM_BUTTON_1);
        arm2 = new JoystickButton(armStick, RobotMap.JOYSTICK_ARM_BUTTON_2);
        arm3 = new JoystickButton(armStick, RobotMap.JOYSTICK_ARM_BUTTON_3);
        arm4 = new JoystickButton(armStick, RobotMap.JOYSTICK_ARM_BUTTON_4);
        arm5 = new JoystickButton(armStick, RobotMap.JOYSTICK_ARM_BUTTON_5);*/
        arm6 = new JoystickButton(armStick, 6);
        arm10 = new JoystickButton(armStick, 10);
        arm11 = new JoystickButton(armStick, 11);
        arm6.whileHeld(new IntakeSpinCommand(Intake.Direction.OUTTAKE, 1));
        arm10.whileHeld(new IntakeSpinCommand(Intake.Direction.OUTTAKE, RobotMap.INTAKE_SPEED));
        arm11.whileHeld(new IntakeSpinCommand(Intake.Direction.INTAKE, RobotMap.INTAKE_SPEED));



        //armTrigger.whenPressed(new SetArmCommandGroup(ArmPosition.REST));

    }
}
