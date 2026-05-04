package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    void givenSameValue_shouldReturnTrue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void givenDifferentValue_shouldReturnFalse() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void givenNull_shouldReturnFalse() {
        Feet f1 = new Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void givenDifferentClass_shouldReturnFalse() {
        Feet f1 = new Feet(1.0);
        String str = "1.0";

        assertFalse(f1.equals(str));
    }

    @Test
    void givenSameReference_shouldReturnTrue() {
        Feet f1 = new Feet(1.0);

        assertTrue(f1.equals(f1));
    }
}