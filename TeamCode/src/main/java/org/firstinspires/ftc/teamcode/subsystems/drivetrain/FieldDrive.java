package org.firstinspires.ftc.teamcode.subsystems.drivetrain;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FieldDrive extends RobotDrive {
    public FieldDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        super(hardwareMap, telemetry);
    }

    public void drive(double forward, double strafe, double turn, double heading) {
        double temp = forward * Math.cos(heading) + strafe * Math.sin(heading);
        strafe = -forward * Math.sin(heading) + strafe * Math.cos(heading);
        forward = temp;

        drive(forward, strafe, turn);
    }

    public void forward(double pwr, double heading) {
        drive(Math.abs(pwr), 0, 0, heading);
    }

    public void backward(double pwr, double heading) {
        drive(-Math.abs(pwr), 0, 0, heading);
    }

    public void left(double pwr, double heading) {
        drive(0, -Math.abs(pwr), 0, heading);
    }

    public void right(double pwr, double heading) {
        drive(0, Math.abs(pwr), 0, heading);
    }

    public void turnLeft(double pwr, double heading) {
        drive(0, 0, Math.abs(pwr), heading);
    }

    public void turnRight(double pwr, double heading) {
        drive(0, 0, -Math.abs(pwr), heading);
    }
}
