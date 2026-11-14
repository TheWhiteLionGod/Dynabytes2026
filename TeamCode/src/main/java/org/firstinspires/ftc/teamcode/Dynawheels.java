package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Roller;
import org.firstinspires.ftc.teamcode.subsystems.sensors.ImuSensor;

public abstract class Dynawheels extends LinearOpMode {
    @Config
    public static class DynawheelsConstant {
        public static double TURN_TO_ANGLE_KP = 0.015;
        public static double TURN_TO_ANGLE_MAX = 0.6;
        public static double TURN_TO_ANGLE_TOLERANCE = Math.PI/90;
    }

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
        while (Math.abs(err) > DynawheelsConstant.TURN_TO_ANGLE_TOLERANCE) {
            double curAngle = imu.getHeading();
            err = targetAngle - curAngle;
            err = ImuSensor.angleWrap(err);

            double pwr = Range.clip(
                    err * DynawheelsConstant.TURN_TO_ANGLE_KP,
                    -Math.abs(DynawheelsConstant.TURN_TO_ANGLE_MAX),
                    Math.abs(DynawheelsConstant.TURN_TO_ANGLE_MAX)
            );
            drivetrain.drive(0, 0, pwr);
        }
        drivetrain.stop();
    }
}
