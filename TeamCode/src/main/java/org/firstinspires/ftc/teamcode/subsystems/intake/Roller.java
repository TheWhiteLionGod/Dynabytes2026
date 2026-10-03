package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Roller {
    private final DcMotorEx roller;
    private final Telemetry telemetry;
    public Roller(HardwareMap hardwareMap, Telemetry telemetry) {
        roller = hardwareMap.get(DcMotorEx.class, "Roller");
        this.telemetry = telemetry;
    }

    public void forward() {
        roller.setPower(0.5);
        telemetry.addData("Roller", "Forward");
    }

    public void backward() {
        roller.setPower(-0.5);
        telemetry.addData("Roller", "Backward");
    }

    public void stop() {
        roller.setPower(0);
        telemetry.addData("Roller", "Stop");
    }
}
