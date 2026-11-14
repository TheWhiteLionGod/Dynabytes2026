package org.firstinspires.ftc.teamcode.subsystems.drivetrain;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Coords;

public class FieldDrive extends RobotDrive {
    public FieldDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        super(hardwareMap, telemetry);
    }

    public void drive(double forward, double strafe, double turn, Coords heading) {
        double angle = heading.toRadians().getHeading();
        double temp = forward * Math.cos(angle) + strafe * Math.sin(angle);
        strafe = -forward * Math.sin(angle) + strafe * Math.cos(angle);
        forward = temp;

        drive(forward, strafe, turn);
    }

    public void forward(double pwr, Coords heading) {
        drive(Math.abs(pwr), 0, 0, heading);
    }

    public void backward(double pwr, Coords heading) {
        drive(-Math.abs(pwr), 0, 0, heading);
    }

    public void left(double pwr, Coords heading) {
        drive(0, -Math.abs(pwr), 0, heading);
    }

    public void right(double pwr, Coords heading) {
        drive(0, Math.abs(pwr), 0, heading);
    }
}
