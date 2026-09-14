package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.sensors.ImuSensor;

@TeleOp(name="TestImu", group="TEST")
public class TestImu extends LinearOpMode {
    ImuSensor imu;

    @Override
    public void runOpMode() {
        imu = new ImuSensor(hardwareMap, telemetry);
        waitForStart();

        while (opModeIsActive()) {
            imu.getHeading();
            telemetry.update();

            sleep(50);
        }
    }
}
