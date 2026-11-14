package org.firstinspires.ftc.teamcode.actions;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Coords;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.RobotDrive;
import org.firstinspires.ftc.teamcode.subsystems.sensors.ImuSensor;

public class TurnDrivetrainTo implements Action {
    @Config
    public static class TurnDrivetrainToConstant {
        public static double TURN_TO_ANGLE_KP = 0.015;
        public static double TURN_TO_ANGLE_MAX = 0.6;
        public static double TURN_TO_ANGLE_TOLERANCE = 2.0;
    }

    private final RobotDrive drivetrain;
    private final ImuSensor imu;
    private final Coords targetAngle;

    public TurnDrivetrainTo(RobotDrive drivetrain, ImuSensor imu, Coords targetAngle) {
        this.drivetrain = drivetrain;
        this.imu = imu;
        this.targetAngle = targetAngle.toDegrees();
    }

    public boolean run() {
        Coords curAngle = imu.getHeading().toDegrees();
        double err = targetAngle.getHeading() - curAngle.getHeading();
        err = Coords.normalize(err, Coords.HeadingType.DEGREES);

        if (Math.abs(err) <= TurnDrivetrainToConstant.TURN_TO_ANGLE_TOLERANCE) {
            drivetrain.stop();
            return true;
        }

        double pwr = Range.clip(
                err * TurnDrivetrainToConstant.TURN_TO_ANGLE_KP,
                -Math.abs(TurnDrivetrainToConstant.TURN_TO_ANGLE_MAX),
                Math.abs(TurnDrivetrainToConstant.TURN_TO_ANGLE_MAX)
        );

        drivetrain.drive(0, 0, pwr);
        return false;
    }
}
