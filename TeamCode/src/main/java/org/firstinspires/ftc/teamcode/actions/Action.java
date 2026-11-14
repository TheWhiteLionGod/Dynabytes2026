package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public interface Action {
    // Returns True if Done
    // Returns False if Incomplete / In Progress
    boolean run();

    default void runBlocking(LinearOpMode opMode) {
        while (!run() && opMode.opModeIsActive()) {
            try { Thread.sleep(10); }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
