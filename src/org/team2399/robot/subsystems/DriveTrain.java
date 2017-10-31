package org.team2399.robot.subsystems;

import org.team2399.robot.RobotMap;
import org.team2399.util.CommandMapping;

import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends TFUSubsystem {

    private CANTalon leftFrontTalon;
    private CANTalon leftRearTalon;
    private CANTalon rightFrontTalon;
    private CANTalon rightRearTalon;
    
    
    public DriveTrain(CommandMapping dfCmd)
    {
        super(dfCmd);
        
        leftFrontTalon = new CANTalon(RobotMap.CAN.DRIVE_LEFT_FRONT_TALON.id());
        leftRearTalon = new CANTalon(RobotMap.CAN.DRIVE_LEFT_REAR_TALON.id());
        rightFrontTalon = new CANTalon(RobotMap.CAN.DRIVE_RIGHT_FRONT_TALON.id());
        rightRearTalon = new CANTalon(RobotMap.CAN.DRIVE_RIGHT_REAR_TALON.id());
        
    }
    
    public void setLeftPercent(double percent)
    {
        double forwardPercent = percent * RobotMap.Forward.Motor.DRIVE_LEFT;
        
        leftFrontTalon.set(forwardPercent);
        leftRearTalon.set(forwardPercent);
    }
    
    public void setRightPercent(double percent)
    {
        double forwardPercent = percent * RobotMap.Forward.Motor.DRIVE_RIGHT;
        
        rightFrontTalon.set(forwardPercent);
        rightRearTalon.set(forwardPercent);
    }
}

