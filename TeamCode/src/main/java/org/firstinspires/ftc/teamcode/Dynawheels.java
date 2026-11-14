package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Roller;
import org.firstinspires.ftc.teamcode.subsystems.outtake.Shooter;
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
        shooter = new Shooter(hardwareMap, telemetry);
    }

    public abstract void run();

    public void cleanup() {
        drivetrain.stop();
        roller.stop();
        shooter.stop();
    }
}
