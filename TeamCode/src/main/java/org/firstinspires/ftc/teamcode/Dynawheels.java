package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Roller;
import org.firstinspires.ftc.teamcode.subsystems.outtake.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.sensors.ImuSensor;
import org.firstinspires.ftc.teamcode.subsystems.transfer.PollenStopper;

public abstract class Dynawheels extends LinearOpMode {
    public RobotDrive drivetrain;
    public ImuSensor imu;
    public Roller roller;
    public PollenStopper pollenStopper;
    public Shooter shooter;

    @Override
    public void runOpMode() {
        telemetry = new MultipleTelemetry(
                telemetry,
                FtcDashboard.getInstance().getTelemetry()
        );

        config();
        telemetry.update();
        waitForStart();

        run();
        cleanup();
    }

    public void config() {
        drivetrain = new RobotDrive(hardwareMap, telemetry);
        imu = new ImuSensor(hardwareMap, telemetry);
        roller = new Roller(hardwareMap, telemetry);
        pollenStopper = new PollenStopper(hardwareMap, telemetry);
        shooter = new Shooter(hardwareMap, telemetry);
    }

    public abstract void run();

    public void cleanup() {
        drivetrain.stop();
        roller.stop();
        pollenStopper.down();
        shooter.stop();
    }
}
