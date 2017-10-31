package org.team2399.robot.subsystems;

import org.team2399.util.CommandMapping;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class TFUSubsystem extends Subsystem {

    private final CommandMapping defaultCommandSupplier;

    public TFUSubsystem(CommandMapping dfCmd) {
        defaultCommandSupplier = dfCmd;
        
    }

    public TFUSubsystem(String name, CommandMapping dfCmd) {
        super(name);
        defaultCommandSupplier = dfCmd;
    }

    public final void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(defaultCommandSupplier.apply(this));
        setDefaultCommand(defaultCommandSupplier.apply(this));
    }


}