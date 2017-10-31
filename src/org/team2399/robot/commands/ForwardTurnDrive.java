package org.team2399.robot.commands;

import java.util.function.DoubleSupplier;

import org.team2399.robot.subsystems.DriveTrain;
import static org.team2399.util.Utility.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class ForwardTurnDrive extends Command {
    
    protected DoubleSupplier forward, turn;
    protected DriveTrain dt;

    private ForwardTurnDrive(DoubleSupplier f, DoubleSupplier t, DriveTrain d) {
        forward = f;
        turn = t;
        dt = d;
        
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    public static ForwardTurnDrive clipImpl(DoubleSupplier f, DoubleSupplier t, DriveTrain d)
    {
        return new ForwardTurnDrive(f, t, d) {
            protected void execute()
            {
                double fwd = forward.getAsDouble();
                double trn = turn.getAsDouble();
                
                dt.setLeftPercent(limitMag1(fwd + trn));
                dt.setRightPercent(limitMag1(fwd - trn));
            }
        };
    }
    
    public static ForwardTurnDrive scaleImpl(DoubleSupplier f, DoubleSupplier t, DriveTrain d)
    {
        return new ForwardTurnDrive(f, t, d) {
            protected void execute()
            {
                double fwd = forward.getAsDouble();
                double trn = turn.getAsDouble();
                
                double mag = Math.abs(fwd) + Math.abs(trn);
                
                double divisor = Math.max(mag, 1.0);
                
                dt.setLeftPercent((fwd + trn) / divisor);
                dt.setRightPercent((fwd - trn) / divisor);
            }
        };
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
