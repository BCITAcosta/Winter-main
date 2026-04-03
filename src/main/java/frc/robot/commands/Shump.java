package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hopper;

public class Shump extends Command {
    private Hopper subSys_hopper = Hopper.getInstance();
    private double curTime = 0.0;
    private double spacingTime = 0.5;
    private double prevTime = 0.0;
    
    public Shump(){
        addRequirements(subSys_hopper);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        curTime = Timer.getFPGATimestamp();
        subSys_hopper.runFeederFwd();
        if(curTime - prevTime > spacingTime){
            if(subSys_hopper.getBlueIndexRunning()){
                subSys_hopper.stopBlueIndex();
                subSys_hopper.runOrangeIndex();
            }else{
                subSys_hopper.stopOrangeIndex();
                subSys_hopper.runBlueIndex();
            }
        }
        prevTime = curTime;
    }

    @Override
    public void end(boolean interrupted){
        subSys_hopper.stopBlueIndex();
        subSys_hopper.stopOrangeIndex();
        subSys_hopper.runFeederIdle();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
