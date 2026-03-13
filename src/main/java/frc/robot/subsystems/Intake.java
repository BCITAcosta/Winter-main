package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private static Intake intake;
    
    private final SparkMax intakeLiftSparkMax;
    private final SparkFlex intakeRollerSparkFlex;
    private final SparkMaxConfig intakeLiftSparkMaxConfig;
    private final SparkFlexConfig intakeRollerFlexConfig;

    public Intake(){
        intakeLiftSparkMax = new SparkMax(52, MotorType.kBrushless);
        intakeLiftSparkMaxConfig = new SparkMaxConfig();
        configureLiftSpark();
        
        intakeRollerSparkFlex = new SparkFlex(51, MotorType.kBrushless);
        intakeRollerFlexConfig = new SparkFlexConfig();
        configureRollerSpark();
    }

    private void configureLiftSpark(){
        intakeLiftSparkMaxConfig.idleMode(IdleMode.kCoast)
        .smartCurrentLimit(80)
        .inverted(false);
        intakeLiftSparkMax.configure(intakeLiftSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    private void configureRollerSpark(){
        intakeRollerFlexConfig.idleMode(IdleMode.kCoast)
        .smartCurrentLimit(80)
        .inverted(false);
        intakeRollerSparkFlex.configure(intakeLiftSparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }

    private void setLiftSpeed(double speed){
        intakeLiftSparkMax.set(speed);
    }

    private void setLiftDropSpeed(double speed){
        setLiftSpeed(speed);
    }

    private void setRollerSpeed(double speed){
        intakeRollerSparkFlex.set(speed);
    }

    public Command intakeExpand(){
        return run(()->{
            setLiftDropSpeed(-0.25);
        });
    }

    public Command intakeRetract(){
        return run(()->{
            setLiftDropSpeed(0.5);
        });
    }

    public Command stopIntakeDrop(){
        return runOnce(()->{
            setLiftSpeed(0.0);
        });
    }

    public Command intakeBalls(){
        return run(()->{
            setRollerSpeed(1);
        });
    }

    public Command outakeBalls(){
        return run(()->{
            setRollerSpeed(-1);
        });
    }

    public Command stopIntaking(){
        return runOnce(()->{
            setRollerSpeed(0);
        });
    }
}
