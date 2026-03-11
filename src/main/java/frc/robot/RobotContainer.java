// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.Autonomous;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.OI.DriverOI;
import frc.robot.util.OI.OperatorOI;


public class RobotContainer {
  private Drivetrain subSys_drivetrain; 
 // private Autonomous subSys_Autonomous;
  // private Hopper subSys_hopper;
  // private Intake subSys_intake;
  
  private DriverOI driverOI;
  private OperatorOI operatorOI;


  public RobotContainer() {
    subSys_drivetrain = Drivetrain.getInstance();
    subSys_drivetrain.setDefaultCommand(new SwerveDriveCommand());

    // subSys_Autonomous = Autonomous.getInstance();
    // subSys_hopper =  Hopper.getInstance();
    // subSys_intake = Intake.getInstance(); 
  
    configureBindings();
  }

  private void configureBindings() {
    driverOI = DriverOI.getInstance();
    operatorOI = OperatorOI.getInstance();
  }

  public Command getAutonomousCommand() {
    return null; //subSys_Autonomous.returnAutonomousCommand();
  }
}
