
package org.team2399.robot;

import org.team2399.robot.subsystems.DriveTrain;
import org.team2399.robot.subsystems.Shifter;
import org.team2399.util.DefaultCommands;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    // Subsystems are declared package-private (no "private", "public", or "protected")
    // NO initialization allowed here!  Only init in robotInit()!
    DriveTrain driveTrain;
    Shifter shifter;

    // everything else is declared private; still no inits here!
    private DefaultCommands defaultCommands;
    private OI oi;
    
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        // defaultCommands object is init'd first
        defaultCommands = new DefaultCommands();

        // subsystems init'd next
        driveTrain = new DriveTrain(defaultCommands.getter());
        shifter = new Shifter(defaultCommands.getter());

        // oi init'd AFTER subsystems
        oi = new OI(this);

        // SET DEFAULT COMMANDS HERE (occurs after oi is init'd)
        defaultCommands.put(driveTrain, oi.tankDrive());
        //defaultCommands.put(driveTrain, oi.tankDriveFun());
        defaultCommands.put(shifter, oi.shiftDefault());

    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
