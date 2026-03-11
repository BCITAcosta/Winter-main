package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.OI.DriverOI;

public class SwerveDriveCommand extends Command{
    private Drivetrain drivetrain = Drivetrain.getInstance();
    private DriverOI driverIO = DriverOI.getInstance();

    public SwerveDriveCommand(){
        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        Translation2d position = driverIO.getSwerveTranslation();
        Double rotation = driverIO.getRotation();
        Translation2d centerOfRotation = driverIO.getCenterOfRotation();

        if(Constants.debugMode){
            SmartDashboard.putNumber("FR - X Axis", position.getX());
            SmartDashboard.putNumber("FR - Y Axis", position.getY());
            SmartDashboard.putNumber("FR - COR X", centerOfRotation.getX());
            SmartDashboard.putNumber("FR - COR Y", centerOfRotation.getY());
            SmartDashboard.putNumber("FR - Rotation", rotation);
        }

        drivetrain.drive(position, rotation, true, centerOfRotation);
    }
    @Override
    public void end(boolean interrupted){
    }
    
    @Override
    public boolean isFinished(){
        return false;
    }
}
