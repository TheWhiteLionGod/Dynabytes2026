package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TestServo", group="TEST")
public class TestServo extends LinearOpMode {
    @Override
    public void runOpMode() {
        Servo servo = hardwareMap.get(Servo.class, "PollenStopper");
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.yWasPressed()) {
                servo.setPosition(servo.getPosition() + 0.1);
            }
            else if (gamepad1.aWasPressed()) {
                servo.setPosition(servo.getPosition() - 0.1);
            }

            telemetry.addData("Servo Pos", servo.getPosition());
            telemetry.update();
        }
    }
}
