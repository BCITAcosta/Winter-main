package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Vision;
import frc.robot.Constants;
import frc.robot.Constants.VisionConstants;
import frc.robot.Constants.VisionConstants.centerCamera;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import frc.robot.subsystems.Drivetrain;

import java.util.function.BooleanSupplier;

import edu.wpi.first.math.geometry.Pose2d;


public class TurretBattery extends SubsystemBase{
    private static TurretBattery turt;
    private Drivetrain m_drive;

    Vision cameraCenter, cameraLeft, cameraRight;

    Turret turtLeft, turtRight;

    private Pose2d robotPosiiton;
    
    public TurretBattery(Drivetrain drivetrainpass){
        cameraCenter = new Vision("AnomCenterCamera", VisionConstants.centerCamera.constants);
        cameraLeft = new Vision("AnomLeftCamera", VisionConstants.leftCamera.constants);
        cameraRight = new Vision("AnomRightCamera", VisionConstants.rightCamera.constants);

        //turtLeft = new Turret(1, Constants.Turret.leftTurt.constants);
        turtRight = new Turret(2, Constants.Turret.rightTurt.constants);

        this.m_drive = drivetrainpass;

        robotPosiiton = m_drive.getPose();


    }
    
    public void deadReconOutside(){
        
        BooleanSupplier hasTraget = () -> cameraCenter.hasTarget();

        double thetaFind = cameraCenter.angleOffOftarget();


    }
    

    






}
