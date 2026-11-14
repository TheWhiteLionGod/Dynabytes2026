package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Coords;
import org.firstinspires.ftc.teamcode.Dynawheels;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;

@Autonomous(name="TestTurnToAngle", group="TEST")
public class TestTurnToAngle extends Dynawheels {
    @Config
    public static class TurnToAngleTestConstants {
        public static Coords[] headings = new Coords[] {
                new Coords(Math.PI/2, Coords.HeadingType.RADIANS),
                new Coords(Math.PI, Coords.HeadingType.RADIANS),
                new Coords(3*Math.PI/2, Coords.HeadingType.RADIANS),
                new Coords(Math.PI/2, Coords.HeadingType.RADIANS),
                new Coords(2*Math.PI, Coords.HeadingType.RADIANS),
                new Coords(Math.PI, Coords.HeadingType.RADIANS),
                new Coords(0, Coords.HeadingType.RADIANS),
        };
    }


    @Override
    public void run() {
        for (Coords heading : TurnToAngleTestConstants.headings) {
            turnToAngle(heading);
            sleep(1000);
        }
        drivetrain.stop();
    }
}
