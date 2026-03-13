package frc.robot.util.OI;

import javax.print.attribute.HashPrintJobAttributeSet;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.OperatorConstants.OperatorJoystickButtons;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;

public class OperatorOI {
    public static OperatorOI instance;

    private final Hopper hopper;
    private final Intake intake;

    private final Joystick operatorJoystick = new Joystick(OperatorConstants.kOperatorJoyPort);

    public OperatorOI(){
        hopper = Hopper.getInstance();
        intake = Intake.getInstance();
        configureButtons();
    }

    private void configureButtons(){
        JoystickButton intakeDown = new JoystickButton(operatorJoystick, OperatorJoystickButtons.kDropIntakeButton);
        intakeDown.onTrue(intake.intakeExpand());
        
        JoystickButton intakeUp = new JoystickButton(operatorJoystick, OperatorJoystickButtons.kRaiseIntakeButton);
        intakeUp.whileTrue(intake.intakeRetract());
        intakeUp.onFalse(intake.stopIntakeDrop());
    
        JoystickButton intakeBalls = new JoystickButton(operatorJoystick, OperatorJoystickButtons.kIntakeButton);
        intakeBalls.whileTrue(intake.intakeBalls());
        intakeBalls.onFalse(intake.stopIntaking());

        JoystickButton outtakeBalls = new JoystickButton(operatorJoystick, OperatorJoystickButtons.kOuttakeButton);
        outtakeBalls.whileTrue(intake.outakeBalls());
        outtakeBalls.onFalse(intake.stopIntaking());

        JoystickButton indexFwd = new JoystickButton(operatorJoystick, OperatorJoystickButtons.kIndexBlueFwd);
        indexFwd.whileTrue(hopper.runBlueIndex());
        indexFwd.whileTrue(hopper.runFeederFwd());
        indexFwd.onFalse(hopper.stopBlueIndex());

        JoystickButton indexRwd = new JoystickButton(operatorJoystick, OperatorJoystickButtons.kIndexBlueRwd);
        indexRwd.whileTrue(hopper.reverseBlueIndex());
        indexRwd.onFalse(hopper.stopBlueIndex());
    }

    public static OperatorOI getInstance(){
        if(instance == null){
            instance = new OperatorOI();
        }
        return instance;
    }
}
