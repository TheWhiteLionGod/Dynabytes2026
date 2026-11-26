package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Dynawheels;
import org.firstinspires.ftc.teamcode.subsystems.outtake.Shooter;

@TeleOp(name="Test Shooter", group="TEST")
public class TestShooter extends Dynawheels {
    @Override
    public void config() {
        Shooter.ShooterConstants.mode = Shooter.ShooterConstants.ShootingMode.POWER;
        super.config();
    }

    public void run() {
        while (opModeIsActive()) {
            if (gamepad1.left_trigger_pressed) roller.forward();
            else if (gamepad1.left_bumper) roller.backward();
            else roller.stop();

            if (gamepad1.rightTriggerWasPressed()) shooter.start();
            else if (gamepad1.yWasPressed()) shooter.reverse();
            else if (gamepad1.rightBumperWasPressed()) shooter.stop();

            if (gamepad1.xWasPressed()) pollenStopper.up();
            else if (gamepad1.bWasPressed()) pollenStopper.down();

            if (gamepad1.dpadUpWasPressed()) shooter.setPower(shooter.getPower() + 0.01);
            else if (gamepad1.dpadDownWasPressed()) shooter.setPower(shooter.getPower() - 0.01);

            telemetry.addData("Shooter Power", shooter.getPower());
            telemetry.update();
            sleep(50);
        }
    }
}
