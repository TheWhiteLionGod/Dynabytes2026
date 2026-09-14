package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class Dynawheels extends LinearOpMode {
    @Override
    public void runOpMode() {
        config();
        waitForStart();
        run();
        cleanup();
    }

    public void config() {}

    public abstract void run();

    public void cleanup() {}
}
