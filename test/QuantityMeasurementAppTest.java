package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void yardEqualsFeet() {
        assertTrue(new Length(1, LengthUnit.YARDS)
                .equals(new Length(3, LengthUnit.FEET)));
    }

    @Test
    void yardEqualsInches() {
        assertTrue(new Length(1, LengthUnit.YARDS)
                .equals(new Length(36, LengthUnit.INCHES)));
    }

    @Test
    void cmEqualsInches() {
        assertTrue(new Length(1, LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, LengthUnit.INCHES)));
    }

    @Test
    void cmNotEqualFeet() {
        assertFalse(new Length(1, LengthUnit.CENTIMETERS)
                .equals(new Length(1, LengthUnit.FEET)));
    }

    @Test
    void transitiveProperty() {
        Length yard = new Length(1, LengthUnit.YARDS);
        Length feet = new Length(3, LengthUnit.FEET);
        Length inches = new Length(36, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
}