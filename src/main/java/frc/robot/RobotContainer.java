// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.Drivetrain;
// import frc.robot.subsystems.Hopper;
// import frc.robot.subsystems.Intake;
import frc.robot.util.DriverOI;

public class RobotContainer {
  private Drivetrain subSys_drivetrain; 
  // private Hopper subSys_hopper;
  // private Intake subSys_intake;
  
  private DriverOI driverOI;

  private Joystick OperatorIO;

  public RobotContainer() {
    subSys_drivetrain = Drivetrain.getInstance();
    subSys_drivetrain.setDefaultCommand(new SwerveDriveCommand());
    // subSys_hopper =  Hopper.getInstance();
    // subSys_intake = Intake.getInstance(); 

    //OperatorIO = new Joystick(2);
    driverOI = DriverOI.getInstance();

    configureBindings();
  }

  private void configureBindings() {
    //Trigger intakeIn 

    //intake out 

    //belt in

    //belt out 

    //^^intake + belt could be spinning at same time 

    //turret spin 

    //shoot 


  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
