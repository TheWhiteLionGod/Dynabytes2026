package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.FieldDrive;
import org.firstinspires.ftc.teamcode.subsystems.sensors.ImuSensor;

@Autonomous(name="TestFieldDrive", group="TEST")
public class TestFieldDrive extends LinearOpMode {
    FieldDrive drivetrain;
    ImuSensor imu;

    @Override
    public void runOpMode() {
        drivetrain = new FieldDrive(hardwareMap, telemetry);
        imu = new ImuSensor(hardwareMap, telemetry);
        waitForStart();

        drivetrain.forward(0.5, imu.getHeading());
        sleep(1000);

        drivetrain.backward(0.5, imu.getHeading());
        sleep(1000);

        drivetrain.left(0.5, imu.getHeading());
        sleep(1000);

        drivetrain.right(0.5, imu.getHeading());
        sleep(1000);

        drivetrain.stop();
    }
}
