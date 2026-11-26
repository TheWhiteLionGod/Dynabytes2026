package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.outtake.Shooter;

@TeleOp(name="One Player Controller", group="Controller")
public class OnePlayerCtrl extends Dynawheels {
    @Override
    public void config() {
        Shooter.ShooterConstants.mode = Shooter.ShooterConstants.ShootingMode.POWER;
        super.config();
    }

    public void run() {
        while (opModeIsActive()) {
            if (gamepad1.left_stick_y != 0 ||
                    gamepad1.left_stick_x != 0 ||
                    gamepad1.right_stick_x != 0
            ) {
                drivetrain.drive(
                        gamepad1.left_stick_y,
                        gamepad1.left_stick_x,
                        gamepad1.right_stick_x
                );
            }
            else {
                drivetrain.stop();
            }

            if (gamepad1.left_trigger_pressed) roller.forward();
            else if (gamepad1.left_bumper) roller.backward();
            else roller.stop();

            if (gamepad1.rightTriggerWasPressed()) shooter.start();
            else if (gamepad1.yWasPressed()) shooter.reverse();
            else if (gamepad1.rightBumperWasPressed()) shooter.stop();

            if (gamepad1.dpadUpWasPressed()) pollenStopper.up();
            else if (gamepad1.dpadDownWasPressed()) pollenStopper.down();

            telemetry.update();
            sleep(50);
        }
    }
}
