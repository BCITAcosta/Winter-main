package frc.robot.util;

public class SDSConstants {
    public enum MK4ModuleGearRatio{
        L1(8.14), 
        L2(6.75), 
        L3(6.12), 
        L4(5.14),
        L1Plus(7.13), 
        L2Plus(5.9), 
        L3Plus(5.36);

        public final double value;

        private MK4ModuleGearRatio(double value){
            this.value = value;
        }
    }

    public enum MK4FreeSpeedNEO{
        L1(12.5),
        L2(15.1),
        L3(16.6),
        L4(19.8),
        L1Plus(14.3),
        L2Plus(17.2),
        L3Plus(19.0);

        public final double value;
        private MK4FreeSpeedNEO(double value){
            this.value = value;
        }
    }
}
