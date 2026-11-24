package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class RunAction implements Action {
    private final Runnable runnable;
    private Thread thread;
    public RunAction(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public boolean run() {
        if (thread != null) {
            return !thread.isAlive();
        }

        thread = new Thread(runnable);
        thread.start();
        return false;
    }

    @Override
    public void runBlocking(LinearOpMode opMode) {
        runnable.run();
    }

    @Override
    public void interrupt() {
        if (thread != null && thread.isAlive())
            thread.interrupt();
    }
}
