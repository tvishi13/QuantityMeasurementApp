package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Enum for units (conversion factor to FEET as base unit)
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toFeet(value);
    }

    // Equality check using base unit
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    // Convert this Length to another unit
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double valueInFeet = this.toBaseUnit();
        double convertedValue = valueInFeet / targetUnit.toFeet(1.0);

        return new Length(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}