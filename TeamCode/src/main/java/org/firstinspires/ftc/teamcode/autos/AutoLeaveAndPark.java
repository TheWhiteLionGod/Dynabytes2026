package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Dynawheels;

@Autonomous(name="AutoLeaveAndPark", group="AUTO")
public class AutoLeaveAndPark extends Dynawheels {
    @Override
    public void config() {
        super.config();
        telemetry.addData("Auto", "8 Points - Leave(3) + Park(5)");
    }

    @Override
    public void run() {
        // TODO: Actually Do Stuff
        telemetry.addLine("NOT WRITTEN!");
        telemetry.update();
    }
}
