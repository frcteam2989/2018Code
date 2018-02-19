package frc.team2989.robot.subsystems;

import frc.team2989.robot.commands.SetWristCommand;

public enum ArmPosition {

    /* Rip 2-step INTAKE(45, 45),
    REST(.34, .49),
    OUTTAKE(90, 90),
    TEST(80, 170);*/
    // Old intake .2013079
    STARTING_FRONT(.2694565, true),
    STARTING_BACK(.29124314241886606, false),
    INTAKE(.22862718129746085, false),
    // INTAKE(0.35337379797873164, false),
    PORTAL(.2575511, true),
    EXCHANGE(.1696136, true),
    SHOOT_BACK(.2743367193044849, true),
    SHOOT_FORWARD(.316586890215012, false);



    private double potentiometerAngle;
    private boolean useSecondPotentiometer;

    ArmPosition(double potentiometerAngle, boolean useSecondPotentiometer) {
        this.potentiometerAngle = potentiometerAngle;
        this.useSecondPotentiometer = useSecondPotentiometer;
    }

    public static SetWristCommand getByPosition(ArmPosition position) {
        return new SetWristCommand(position.getAngle(), position.useSecondPotentiometer());
    }

    public double getAngle() {
        return potentiometerAngle;
    }

    public boolean useSecondPotentiometer() {
        return useSecondPotentiometer;
    }
}
