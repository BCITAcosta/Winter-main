package frc.robot.util.OI;

public class OperatorOI {
    public static OperatorOI instance;

    public OperatorOI(){
        
    }

    public static OperatorOI getInstance(){
        if(instance == null){
            instance = new OperatorOI();
        }
        return instance;
    }
}
