package org.team2399.robot.subsystems;

import org.team2399.robot.RobotMap;
import org.team2399.util.CommandMapping;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class Shifter extends TFUSubsystem {

    private DoubleSolenoid shifterValve;
    
    public enum Speed
    {
        FAST(DoubleSolenoid.Value.kForward),
        SLOW(DoubleSolenoid.Value.kReverse),
        HOLD(DoubleSolenoid.Value.kOff);
        
        private DoubleSolenoid.Value mapping;
        private Speed(DoubleSolenoid.Value val) {mapping = val;}
        private DoubleSolenoid.Value getMapping() {return mapping;}
    }
    
    public Shifter(CommandMapping dfCmd) {
        super(dfCmd);
        
        shifterValve = new DoubleSolenoid(RobotMap.CAN.PCM.id(),
                                RobotMap.PCM.SHIFTER_SLOW,
                                RobotMap.PCM.SHIFTER_FAST);
    }

    public void shift(Speed s)
    {
        shifterValve.set(s.getMapping());
    }
}

