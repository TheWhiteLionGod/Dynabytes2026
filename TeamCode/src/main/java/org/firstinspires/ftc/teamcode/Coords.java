package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Coords {
    public enum HeadingType {
        RADIANS, // [-pi, pi]
        DEGREES // [-180, 180]
    }

    private final double heading;
    private final HeadingType headingType;

    public Coords(double heading, HeadingType headingType) {
        this.heading = Coords.normalize(heading, headingType);
        this.headingType = headingType;
    }

    public Coords toRadians() {
        if (headingType == HeadingType.RADIANS) return this;
        return new Coords(Math.toRadians(heading), HeadingType.RADIANS);
    }

    public Coords toDegrees() {
        if (headingType == HeadingType.DEGREES) return this;
        return new Coords(Math.toDegrees(heading), HeadingType.DEGREES);
    }

    public double getHeading() {
        return heading;
    }

    public HeadingType getHeadingType() {
        return headingType;
    }

    public static double normalize(double heading, HeadingType headingType) {
        if (headingType == HeadingType.DEGREES)
            return AngleUnit.normalizeDegrees(heading);
        return AngleUnit.normalizeRadians(heading);
    }
}
