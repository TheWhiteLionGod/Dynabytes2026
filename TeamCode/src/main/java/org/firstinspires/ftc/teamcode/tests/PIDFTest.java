/*
WATCH THIS VIDEO BEFORE TUNING: https://www.youtube.com/watch?v=aPNCpZzCTKg
*/
package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp(name="PIDF Test", group="TEST")
public class PIDFTest extends LinearOpMode {
    @Config
    public static class PIDFTestConstants {
        public static PIDFCoefficients PIDF = new PIDFCoefficients();
        public static double LOW_TARGET_VEL = 400;
        public static double HIGH_TARGET_VEL = 1400;
        public static double[] STEP_SIZE = new double[] {100, 10, 1, 0.1, 0.01, 0.001};
    }

    DcMotorEx shooter;
    double curTargetVel = PIDFTestConstants.LOW_TARGET_VEL;
    double P = PIDFTestConstants.PIDF.p;
    double F = PIDFTestConstants.PIDF.f;
    int stepSizePtr = 0;

    @Override
    public void runOpMode() {
        shooter = hardwareMap.get(DcMotorEx.class, "Shooter");
        shooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        shooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, PIDFTestConstants.PIDF);

        telemetry.addData("Shooter", "Initialized");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.aWasPressed()) curTargetVel = PIDFTestConstants.LOW_TARGET_VEL;
            else if (gamepad1.yWasPressed()) curTargetVel = PIDFTestConstants.HIGH_TARGET_VEL;
            shooter.setVelocity(curTargetVel);

            if (gamepad1.dpad_up) P += PIDFTestConstants.STEP_SIZE[stepSizePtr];
            else if (gamepad1.dpad_down) P -= PIDFTestConstants.STEP_SIZE[stepSizePtr];

            if (gamepad1.dpad_left) F += PIDFTestConstants.STEP_SIZE[stepSizePtr];
            else if (gamepad1.dpad_right) F -= PIDFTestConstants.STEP_SIZE[stepSizePtr];

            if (gamepad1.xWasPressed())
                stepSizePtr = (stepSizePtr + 1) % PIDFTestConstants.STEP_SIZE.length;
            else if (gamepad1.bWasPressed())
                stepSizePtr = (stepSizePtr - 1) % PIDFTestConstants.STEP_SIZE.length;

            PIDFTestConstants.PIDF = new PIDFCoefficients(P, 0, 0, F);
            shooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, PIDFTestConstants.PIDF);

            telemetry.addData("P", P);
            telemetry.addData("F", F);
            telemetry.addData("Current Velocity", shooter.getVelocity());
            telemetry.addData("Target Velocity", curTargetVel);
            telemetry.addData("Step Size", PIDFTestConstants.STEP_SIZE[stepSizePtr]);
            telemetry.update();
            sleep(50);
        }

        shooter.setPower(0);
    }
}
