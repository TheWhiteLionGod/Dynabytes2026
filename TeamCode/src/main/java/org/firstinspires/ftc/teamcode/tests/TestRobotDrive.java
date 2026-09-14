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

        drivetrain.robotForward(0.5);
        sleep(1000);

        drivetrain.robotBackward(0.5);
        sleep(1000);

        drivetrain.robotLeft(0.5);
        sleep(1000);

        drivetrain.robotRight(0.5);
        sleep(1000);

        drivetrain.robotTurnLeft(0.5);
        sleep(1000);

        drivetrain.robotTurnRight(0.5);
        sleep(1000);

        drivetrain.stop();
    }
}
