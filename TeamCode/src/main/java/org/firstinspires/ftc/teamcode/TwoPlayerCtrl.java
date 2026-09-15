package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Two Player Controller", group="Controller")
public class TwoPlayerCtrl extends Dynawheels {
    public void run() {
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
    }
}
