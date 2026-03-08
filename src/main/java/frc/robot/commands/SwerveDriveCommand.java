package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.DriverOI;

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

        drivetrain.drive(position, rotation, true, centerOfRotation);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
