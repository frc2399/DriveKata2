package org.team2399.util;

import java.util.function.Function;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public interface CommandMapping extends Function<Subsystem,Command>{

}
