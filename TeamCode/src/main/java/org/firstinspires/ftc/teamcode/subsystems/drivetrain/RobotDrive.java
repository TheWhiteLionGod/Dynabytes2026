package org.firstinspires.ftc.teamcode.subsystems.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotDrive {
    private final DcMotorEx BL, FL, FR, BR;
    private final Telemetry telemetry;

    public RobotDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        BL = hardwareMap.get(DcMotorEx.class, "BL");
        FL = hardwareMap.get(DcMotorEx.class, "FL");
        FR = hardwareMap.get(DcMotorEx.class, "FR");
        BR = hardwareMap.get(DcMotorEx.class, "BR");

        BR.setDirection(DcMotorEx.Direction.REVERSE);
        FR.setDirection(DcMotorEx.Direction.REVERSE);

        BL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        this.telemetry = telemetry;
        telemetry.addData("Drivetrain", "Initialized");
    }

    public void drive(double forward, double strafe, double turn) {
        double frontLeft = forward + strafe - turn;
        double backLeft = forward - strafe - turn;
        double frontRight = forward - strafe + turn;
        double backRight = forward + strafe + turn;

        double max = Math.max(
                Math.max(Math.abs(frontLeft), Math.abs(backLeft)),
                Math.max(Math.abs(frontRight), Math.abs(backRight))
        );

        if (max > 1.0) {
            frontLeft /= max;
            backLeft /= max;
            frontRight /= max;
            backRight /= max;
        }

        BL.setPower(backLeft);
        FL.setPower(frontLeft);
        FR.setPower(frontRight);
        BR.setPower(backRight);

        telemetry.addData("Drivetrain", "Moving");
    }

    public void forward(double pwr) {
        drive(Math.abs(pwr), 0, 0);
    }

    public void backward(double pwr) {
        drive(-Math.abs(pwr), 0, 0);
    }

    public void left(double pwr) {
        drive(0, -Math.abs(pwr), 0);
    }

    public void right(double pwr) {
        drive(0, Math.abs(pwr), 0);
    }

    public void turnLeft(double pwr) {
        drive(0, 0, Math.abs(pwr));
    }

    public void turnRight(double pwr) {
        drive(0, 0, -Math.abs(pwr));
    }

    public void stop() {
        BL.setPower(0);
        FL.setPower(0);
        FR.setPower(0);
        BR.setPower(0);
        telemetry.addData("Drivetrain", "Stopped");
    }
}
