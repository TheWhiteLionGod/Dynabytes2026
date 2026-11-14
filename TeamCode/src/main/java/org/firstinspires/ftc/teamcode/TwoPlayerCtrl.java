package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Two Player Controller", group="Controller")
public class TwoPlayerCtrl extends Dynawheels {
    public void run() {
        while (opModeIsActive()) {
            if (gamepad1.left_stick_y != 0 ||
                    gamepad1.left_stick_x != 0 ||
                    gamepad1.right_stick_x != 0
            ) {
                drivetrain.drive(
                        -gamepad1.left_stick_y,
                        gamepad1.left_stick_x,
                        gamepad1.right_stick_x
                );
            }
            else {
                drivetrain.stop();
            }

            if (gamepad1.right_trigger_pressed) roller.forward();
            else if (gamepad1.right_bumper) roller.backward();
            else roller.stop();

            if (gamepad1.rightTriggerWasPressed()) shooter.start();
            else if (gamepad1.rightBumperWasPressed()) shooter.stop();

            telemetry.update();
            sleep(50);
        }
    }
}
