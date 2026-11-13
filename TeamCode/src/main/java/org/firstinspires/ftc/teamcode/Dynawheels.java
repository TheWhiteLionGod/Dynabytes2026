package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Roller;
import org.firstinspires.ftc.teamcode.subsystems.sensors.ImuSensor;

public abstract class Dynawheels extends LinearOpMode {
    public RobotDrive drivetrain;
    public ImuSensor imu;
    public Roller roller;

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
        imu = new ImuSensor(hardwareMap, telemetry);
        roller = new Roller(hardwareMap, telemetry);
    }

    public abstract void run();

    public void cleanup() {
        drivetrain.stop();
        roller.stop();
    }

    public void turnToAngle(double targetAngle) {
        double err = Math.PI;
        while (Math.abs(err) > Math.PI/90) {
            double curAngle = imu.getHeading();
            err = targetAngle - curAngle;
            err = ImuSensor.angleWrap(err);

            double pwr = Range.clip(err * 0.015, -0.6, 0.6);
            drivetrain.drive(0, 0, pwr);
        }
        drivetrain.stop();
    }
}
