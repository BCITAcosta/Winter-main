package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hopper extends SubsystemBase{
    private static Hopper hopper;

    private final SparkFlex towerFeeder;
    private final SparkMax blueTowerIndexer;
    private final SparkMax orangeTowerIndexer;

    private final SparkFlexConfig towerFeederConfig;
    private final SparkMaxConfig indexerConfig;

    public Hopper(){
        towerFeeder = new SparkFlex(61, MotorType.kBrushless);
        blueTowerIndexer = new SparkMax(57, MotorType.kBrushless);
        orangeTowerIndexer = new SparkMax(58, MotorType.kBrushless);

        towerFeederConfig = new SparkFlexConfig();
        configureTowerFeeder();
        indexerConfig = new SparkMaxConfig();
        configureIndexers();
    }

    private void configureTowerFeeder(){
        towerFeederConfig.smartCurrentLimit(80)
        .inverted(false)
        .idleMode(IdleMode.kCoast);
        towerFeeder.configure(towerFeederConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    private void configureIndexers(){
        indexerConfig.smartCurrentLimit(80)
        .inverted(false)
        .idleMode(IdleMode.kBrake);
        blueTowerIndexer.configure(indexerConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        orangeTowerIndexer.configure(indexerConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public static Hopper getInstance(){
        if(hopper == null){
            hopper = new Hopper();
        }
        return hopper;
    }

    private void setFeederSpeed(double speed){
        towerFeeder.set(speed);
    }

    private void setBlueIndexerSpeed(double speed){
        blueTowerIndexer.set(speed);
    }

    private void setOrangeIndexerSpeed(double speed){
        orangeTowerIndexer.set(speed);
    }

    public boolean getBlueIndexRunning(){
        if(blueTowerIndexer.get() > 0){
            return true;
        }
        return false;
    }

        public boolean getOrangeIndexRunning(){
        if(blueTowerIndexer.get() > 0){
            return true;
        }
        return false;
    }
    
    public Command runFeederFwd(){
        return run(()->{
            setFeederSpeed(1);
        });
    }

    public Command runFeederIdle(){
        return run(()->{
            setFeederSpeed(0.5);
        });
    }

    public Command stopFeeder(){
        return run(()->{
            setFeederSpeed(0);
        });
    }

    public Command runBlueIndex(){
        return run(()->{
            setBlueIndexerSpeed(1);
        });
    }

    public Command reverseBlueIndex(){
        return run(()->{
            setBlueIndexerSpeed(-1);
        });
    }

    public Command stopBlueIndex(){
        return run(()->{
            setBlueIndexerSpeed(0);
        });
    }

        public Command runOrangeIndex(){
        return run(()->{
            setOrangeIndexerSpeed(1);
        });
    }

    public Command reverseOrangeIndex(){
        return run(()->{
            setOrangeIndexerSpeed(-1);
        });
    }

    public Command stopOrangeIndex(){
        return run(()->{
            setOrangeIndexerSpeed(0);
        });
    }
}