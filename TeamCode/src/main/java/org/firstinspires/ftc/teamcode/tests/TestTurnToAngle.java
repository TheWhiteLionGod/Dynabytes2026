package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Dynawheels;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;

@Autonomous(name="TestRobotDrive", group="TEST")
public class TestTurnToAngle extends Dynawheels {

    @Override
    public void run() {
        turnToAngle(Math.PI/2);
        sleep(1000);

        turnToAngle(Math.PI);
        sleep(1000);

        turnToAngle(3*Math.PI/2);
        sleep(1000);

        turnToAngle(Math.PI/2);
        sleep(1000);

        turnToAngle(2*Math.PI);
        sleep(1000);

        turnToAngle(Math.PI);
        sleep(1000);

        turnToAngle(0);
        sleep(1000);

        drivetrain.stop();
    }
}
