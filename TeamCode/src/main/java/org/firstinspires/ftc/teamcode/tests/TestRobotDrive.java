package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;

@Autonomous(name="TestRobotDrive", group="TEST")
public class TestRobotDrive extends LinearOpMode {
    RobotDrive drivetrain;

    @Override
    public void runOpMode() {
        drivetrain = new RobotDrive(hardwareMap, telemetry);
        waitForStart();

        drivetrain.forward(0.5);
        sleep(1000);

        drivetrain.backward(0.5);
        sleep(1000);

        drivetrain.left(0.5);
        sleep(1000);

        drivetrain.right(0.5);
        sleep(1000);

        drivetrain.turnLeft(0.5);
        sleep(1000);

        drivetrain.turnRight(0.5);
        sleep(1000);

        drivetrain.stop();
    }
}
