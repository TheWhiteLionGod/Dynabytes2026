package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.acmerobotics.dashboard.config.Config;
<<<<<<< HEAD
import com.qualcomm.robotcore.hardware.DcMotor;
=======
>>>>>>> 111d475 (Made Shooter Class and Updated PIDF Testing)
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    @Config
    public static class ShooterConstants {
        public static PIDFCoefficients PIDF = new PIDFCoefficients();
<<<<<<< HEAD
        public static double DEFAULT_SHOOTING_VEL = 3000;
        public static double DEFAULT_SHOOTING_PWR = 0.65;
        public static ShootingMode mode = ShootingMode.ENCODER;

        public enum ShootingMode {
            ENCODER,
            POWER
        }
=======
        public static double SHOOTING_VEL = 0;
>>>>>>> 111d475 (Made Shooter Class and Updated PIDF Testing)
    }

    private final DcMotorEx shooter;
    private final Telemetry telemetry;

<<<<<<< HEAD
    private double velocity = ShooterConstants.DEFAULT_SHOOTING_VEL;
    private double power = ShooterConstants.DEFAULT_SHOOTING_PWR;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        shooter = hardwareMap.get(DcMotorEx.class, "Shooter");
        switch (ShooterConstants.mode) {
            case ENCODER:
                shooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
                shooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, ShooterConstants.PIDF);
                break;

            case POWER:
                shooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                break;
        }

        this.telemetry = telemetry;
        telemetry.addData("Shooter", ShooterConstants.mode.toString());
    }

    public void start() {
        switch (ShooterConstants.mode) {
            case ENCODER:
                shooter.setVelocity(velocity);
                break;

            case POWER:
                shooter.setPower(power);
                break;
        }
        telemetry.addData("Shooter", "Spinning");
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = Math.min(1, Math.max(power, -1));
    }

=======
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

>>>>>>> 111d475 (Made Shooter Class and Updated PIDF Testing)
    public void stop() {
        shooter.setPower(0);
        telemetry.addData("Shooter", "Stopped");
    }
}
