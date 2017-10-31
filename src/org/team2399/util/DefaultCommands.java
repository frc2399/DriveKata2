package org.team2399.util;

import java.util.HashMap;
import java.util.function.Function;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DefaultCommands {
    private HashMap<Subsystem, Command> data;
    
    public DefaultCommands()
    {
        data = new HashMap<>();
    }
    
    public <S extends Subsystem> void put(S sys, Function<S,Command> comFun)
    {
        put(sys, comFun.apply(sys));
    }
    
    public void put(Subsystem sys, Command com)
    {
        if(sys == null) throw new NullPointerException("Subsystem may not be null!");
        if(com == null) throw new NullPointerException("Command may not be null!");
        
        if(data.containsKey(sys)) throw new IllegalArgumentException("Default command already set!");
        
        data.put(sys, com);
    }
    
    public Command get(Subsystem sys)
    {
        return data.get(sys);
    }
    
    public CommandMapping getter()
    {
        return (s)->data.get(s);
    }

}
