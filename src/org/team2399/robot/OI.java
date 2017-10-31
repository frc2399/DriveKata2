package org.team2399.robot;

import java.util.function.Function;

import org.team2399.robot.commands.ForwardTurnDrive;
import org.team2399.robot.commands.Shift;
import org.team2399.robot.commands.TankDrive;
import org.team2399.robot.subsystems.DriveTrain;
import org.team2399.robot.subsystems.Shifter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Joystick driverGamepad;
    private Robot robot;

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    private Button driverShoulderTopLeft;
    private Button driverShoulderTopRight;
    
    public OI(Robot r)
    {
        robot = r;

        driverGamepad = new Joystick(RobotMap.Joysticks.DRIVER_GAMEPAD);

        driverShoulderTopLeft = 
                new JoystickButton(driverGamepad,
                                   LogitechDualAction.Buttons.SHOULDER_TOP_LEFT.id());
        driverShoulderTopRight = 
                new JoystickButton(driverGamepad,
                                   LogitechDualAction.Buttons.SHOULDER_TOP_RIGHT.id());
        
        
        driverShoulderTopLeft.whenPressed(new Shift(robot.shifter, Shifter.Speed.SLOW));
        driverShoulderTopRight.whenPressed(new Shift(robot.shifter, Shifter.Speed.FAST));
    }

    public Command tankDrive()
    {
        return new TankDrive(
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.LEFT_Y.id()),
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.RIGHT_Y.id()),
            robot.driveTrain);
    }
    
    public Function<DriveTrain,Command> tankDriveFun()
    {
        return (dt)->new TankDrive(
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.LEFT_Y.id()),
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.RIGHT_Y.id()),
            dt);
    }

    public Command arcadeDrive()
    {
        return ForwardTurnDrive.clipImpl(
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.LEFT_Y.id()),
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.LEFT_X.id()),
            robot.driveTrain);
    }

    public Command kajDrive()
    {
        return ForwardTurnDrive.clipImpl(
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.LEFT_Y.id()),
            ()->driverGamepad.getRawAxis(LogitechDualAction.Axes.RIGHT_X.id()),
            robot.driveTrain);
    }

    public Command shiftDefault()
    {
        return new Shift(robot.shifter, Shifter.Speed.SLOW);
    }

    //Gamepad mappings
    public static class LogitechDualAction
    {
        public enum Buttons
        {
            SHOULDER_TOP_LEFT(0),
            SHOULDER_BOT_LEFT(1),
            SHOULDER_TOP_RIGHT(2),
            SHOULDER_BOT_RIGHT(3);


            private final int id;
            private Buttons(int i) {id = i;}
            public int id() {return id;}
        }

        public enum Axes
        {
            LEFT_Y(0),
            LEFT_X(1),
            RIGHT_Y(3),
            RIGHT_X(2);

            private final int id;
            private Axes(int i) {id = i;}
            public int id() {return id;}
        }
    }


}
