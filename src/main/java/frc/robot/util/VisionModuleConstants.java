package frc.robot.util;

public class VisionModuleConstants {
    public final int outsideID, insideID;
    public final double cameraPosX, cameraPosY, cameraPosZ;

    public VisionModuleConstants(int outsideAprilTag, int insideAprilTag, int posX, int posY, int posZ){
        this.outsideID = outsideAprilTag;
        this.insideID = insideAprilTag;
        this.cameraPosX = posX;
        this.cameraPosY = posY;
        this.cameraPosZ = posZ;
    }
}
