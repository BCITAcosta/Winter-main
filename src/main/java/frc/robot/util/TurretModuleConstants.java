package frc.robot.util;

public class TurretModuleConstants {
    public final int turnMotorID;
    public final int shooterMotorLeftID, shooterMotorRightID;

    public final double idleRPM, maxRPM, maxAcceleration;

    public final double kP, kI, kD;

    public final boolean turnMotorInverted, shooterMotorLeftInverted, shooterMotorRightInverted;

    /**
     * Turret Module Constants to be used when creating turret modules;
     * @param turnMotorID
     * @param shooterMotorLeftID
     * @param shooterMotorRightID

     * @param turnMotorInverted
     * @param shooterMotorLeftInverted
     * 
     * @param pidValues PID Values in the order of P, I, D
     */
    
    public TurretModuleConstants(int turnMotorID, int shooterMotorLeftID, int shooterMotorRightID, double idleRPM, double maxRPM, double maxAcceleration, boolean turnMotorInverted, boolean shooterMotorLeftInverted, double[] pidValues){
        this.turnMotorID = turnMotorID;
        this.shooterMotorLeftID = shooterMotorLeftID;
        this.shooterMotorRightID = shooterMotorRightID;
        this.idleRPM = idleRPM;
        this.maxRPM = maxRPM;
        this.maxAcceleration = maxAcceleration;
        this.kP = pidValues[0];
        this.kI = pidValues[1];
        this.kD = pidValues[2];
        this.turnMotorInverted = turnMotorInverted;
        this.shooterMotorLeftInverted = shooterMotorLeftInverted;
        this.shooterMotorRightInverted = !shooterMotorLeftInverted;
    }
    
}
