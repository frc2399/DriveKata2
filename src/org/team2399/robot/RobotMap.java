package org.team2399.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * RobotMap's responsibility is to provide a central location for all of the
 * physical connections made to the roboRIO and DS.  Therefore, it should be
 * organized by items that are found in the same locations.  This enables
 * a person to compare this map to the robot and synchronize the two.  
 * 
 * For example, 
 * - PWM ports are grouped -- check the line of PWM connectors on the roboRIO
 * - CAN devices are grouped -- check the web dashboard of the roboRIO
 * - Joysticks are grouped -- check the USB list of the Driver Station
 * 
 * Furthermore, it is important to group the 
 */
public class RobotMap {
    
    // Joystick ports
//    public enum Joysticks
//    {
//        DRIVER_GAMEPAD(0);
//        //OPERATOR_GAMEPAD(1);
//        
//        private final int id;
//        private Joysticks(int i) {id = i;}
//        public int id() {return id;}
//    }
//    
    public static class Joysticks
    {
        public static final int DRIVER_GAMEPAD = 0;
    }
    
    // CAN addresses
    public enum CAN
    {
        DRIVE_LEFT_FRONT_TALON(1),
        DRIVE_LEFT_REAR_TALON(2),
        DRIVE_RIGHT_FRONT_TALON(3),
        DRIVE_RIGHT_REAR_TALON(4),
        
        PDP(0),
        
        PCM(3);
        
        private final int id;
        private CAN(int i) {id = i;}
        public int id() {return id;}
    }
    
    public static class Forward
    {
        public static class Motor
        {
            public static final int DRIVE_LEFT = 1;
            public static final int DRIVE_RIGHT = -1;
        }
    }
    
    // Solenoids connected to PCM
    public static class PCM
    {
        public static final int GEAR_OUT = 0;
        public static final int GEAR_IN = 1;
        
        public static final int SHIFTER_SLOW = 2;
        public static final int SHIFTER_FAST = 3;
    }
    
    // PWM ports
    public static class PWM
    {
        
        private final int port;
        private PWM(int p) {port = p;}
        public int port() {return port;}
    }
    
    // Relay ports
    public static class Relay
    {
        private final int port;
        private Relay(int p) {port = p;}
        public int port() {return port;}
    }
    
    // Analog ports
    public static class Analog
    {
        private final int port;
        private Analog(int p) {port = p;}
        public int port() {return port;}
    }
    
    // Digital I/O ports
    public static class DigitalIO
    {
        private final int port;
        private DigitalIO(int p) {port = p;}
        public int port() {return port;}
    }
    
    // robot physical constants
    public static class Physical
    {
        public static final double WHEEL_DIAMETER = 4.0;
    }
}
