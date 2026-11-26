package org.firstinspires.ftc.teamcode.subsystems.transfer;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PollenStopper {
    @Config
    public static class PollenStopperConstants {
        public static double DOWN_POS = 0.0;
        public static double UP_POS = 0.5;
    }

    private final Servo stopper;
    private final Telemetry telemetry;

    public PollenStopper(HardwareMap hardwareMap, Telemetry telemetry) {
        stopper = hardwareMap.get(Servo.class, "pgate");
        stopper.setPosition(PollenStopperConstants.DOWN_POS);

        this.telemetry = telemetry;
        telemetry.addData("PollenStopper", "Initialized");
    }

    public void up() {
        stopper.setPosition(PollenStopperConstants.UP_POS);
        telemetry.addData("PollenStopper", "Up");
    }

    public void down() {
        stopper.setPosition(PollenStopperConstants.DOWN_POS);
        telemetry.addData("PollenStopper", "Down");
    }
}
