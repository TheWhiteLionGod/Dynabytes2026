package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Roller {
    @Config
    public static class RollerConstants {
        public static double POWER = 0.5;
    }

    private final DcMotorEx roller;
    private final Telemetry telemetry;
    public Roller(HardwareMap hardwareMap, Telemetry telemetry) {
        roller = hardwareMap.get(DcMotorEx.class, "Roller");
        this.telemetry = telemetry;
        telemetry.addData("Roller", "Initialized");
    }

    public void forward() {
        roller.setPower(Math.abs(RollerConstants.POWER));
        telemetry.addData("Roller", "Forward");
    }

    public void backward() {
        roller.setPower(-Math.abs(RollerConstants.POWER));
        telemetry.addData("Roller", "Backward");
    }

    public void stop() {
        roller.setPower(0);
        telemetry.addData("Roller", "Stop");
    }
}
