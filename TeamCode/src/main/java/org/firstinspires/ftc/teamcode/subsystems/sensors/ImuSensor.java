package org.firstinspires.ftc.teamcode.subsystems.sensors;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class ImuSensor {
    @Config
    public static class ImuSensorConstants {
        public static RevHubOrientationOnRobot.LogoFacingDirection logoFacingDirection
                = RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
        public static RevHubOrientationOnRobot.UsbFacingDirection usbFacingDirection
                = RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD;
    }

    private final IMU imu;
    private final Telemetry telemetry;

    public ImuSensor(HardwareMap hardwareMap, Telemetry telemetry) {
        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                ImuSensorConstants.logoFacingDirection,
                ImuSensorConstants.usbFacingDirection
        )));
        imu.resetYaw();

        this.telemetry = telemetry;
        telemetry.addData("IMU", "Initialized");
    }

    public double getHeading() {
        double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        telemetry.addData("IMU", "Current Heading is " + heading);
        return heading;
    }

    public static double angleWrap(double radians) {
        return Math.IEEEremainder(radians, 2 * Math.PI);
    }

    public double angleWrap() {
        return ImuSensor.angleWrap(getHeading());
    }
}
