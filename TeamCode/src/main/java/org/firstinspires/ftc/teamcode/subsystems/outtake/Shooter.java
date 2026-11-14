package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    @Config
    public static class ShooterConstants {
        public static PIDFCoefficients PIDF = new PIDFCoefficients();
        public static double SHOOTING_VEL = 0;
    }

    private final DcMotorEx shooter;
    private final Telemetry telemetry;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        shooter = hardwareMap.get(DcMotorEx.class, "Shooter");
        shooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        shooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, ShooterConstants.PIDF);

        this.telemetry = telemetry;
        telemetry.addData("Shooter", "Initialized");
    }

    public void start() {
        shooter.setVelocity(ShooterConstants.SHOOTING_VEL);
        telemetry.addData("Shooter", "Spinning");
    }

    public void stop() {
        shooter.setPower(0);
        telemetry.addData("Shooter", "Stopped");
    }
}
