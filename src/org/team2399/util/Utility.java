package org.team2399.util;

public class Utility {
    
    public static double limitMag1(double input)
    {
      double minLimit = Math.min(1.0, input);
      
      return Math.max(-1.0, minLimit);
    }
    
    

}
