package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.outtake.Shooter;

@TeleOp(name="Two Player Controller", group="Controller")
public class TwoPlayerCtrl extends Dynawheels {
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

            if (gamepad2.left_trigger_pressed) roller.forward();
            else if (gamepad2.left_bumper) roller.backward();
            else roller.stop();

            if (gamepad2.rightTriggerWasPressed()) shooter.start();
            else if (gamepad2.yWasPressed()) shooter.reverse();
            else if (gamepad2.rightBumperWasPressed()) shooter.stop();

            if (gamepad2.dpadUpWasPressed()) pollenStopper.up();
            else if (gamepad2.dpadDownWasPressed()) pollenStopper.down();

            telemetry.update();
            sleep(50);
        }
    }
}
