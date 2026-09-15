package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;

public abstract class Dynawheels extends LinearOpMode {
    RobotDrive drivetrain;

    @Override
    public void runOpMode() {
        telemetry = new MultipleTelemetry(
                telemetry,
                FtcDashboard.getInstance().getTelemetry()
        );

        config();
        waitForStart();

        try { run(); }
        finally { cleanup(); }
    }

    public void config() {
        drivetrain = new RobotDrive(hardwareMap, telemetry);
    }

    public abstract void run();

    public void cleanup() {
        drivetrain.stop();
    }
}
