package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Dynawheels;

@Autonomous(name="Leave And Park Blue Rear", group="BLUE-REAR")
public class BlueRearLeaveAndPark extends Dynawheels {
    @Override
    public void config() {
        super.config();
        telemetry.addData("Auto", "8 Points - Leave(3) + Park(5)");
    }

    @Override
    public void run() {
        drivetrain.forward(0.25);
        sleep(100);

        drivetrain.left(0.5);
        sleep(1500);

        drivetrain.forward(0.5);
        sleep(1500);

        drivetrain.left(0.25);
        sleep(250);

        telemetry.update();
    }
}
