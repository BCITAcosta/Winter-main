package frc.robot.util;

public class TurretModuleConstants {
    public final int turnMotorID;
    public final int shooterMotorLeftID, shooterMotorRightID;

    public final double idleRPM, maxRPM, maxAcceleration;

    public final double kP, kI, kD;

    public final boolean turnMotorInverted, shooterMotorLeftInverted, shooterMotorRightInverted, enabled;

    /**
     * Turret Module Constants to be used when creating turret modules;
     * @param turnMotorID
     * @param shooterMotorLeftID
     * @param shooterMotorRightID

     * @param turnMotorInverted
     * @param shooterMotorLeftInverted
     * 
     * @param pidValues PID Values in the order of P, I, D
     * @param idleRPM The RPM the shooter motors will be at when not shooting, but still spinning. This is to prevent jamming and allow for quicker spin up.
     * @param maxRPM The maximum RPM the shooter motors will be allowed to reach. This is to prevent damage to the motors and to allow for more consistent shooting.
     * @param maxAcceleration The maximum acceleration the shooter motors will be allowed to reach. This is to prevent damage to the motors and to allow for more consistent shooting.
     * 
     * @param enabled Whether or not the turret module is enabled. This is to allow for testing of the turret module without having to worry about it breaking the robot.
     */
    
    public TurretModuleConstants(int turnMotorID, int shooterMotorLeftID, int shooterMotorRightID, double idleRPM, double maxRPM, double maxAcceleration, boolean turnMotorInverted, boolean shooterMotorLeftInverted, double[] pidValues, boolean enabled){
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
        this.enabled = enabled;
    }
    
}
