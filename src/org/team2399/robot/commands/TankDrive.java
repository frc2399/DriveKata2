package org.team2399.robot.commands;

import java.util.function.DoubleSupplier;

import org.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {
    
    private DoubleSupplier left, right;
    private DriveTrain dt;

    public TankDrive(DoubleSupplier l, DoubleSupplier r, DriveTrain d) {
        left = l;
        right = r;
        dt = d;
        
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.setLeftPercent(left.getAsDouble());
        dt.setRightPercent(right.getAsDouble());
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
