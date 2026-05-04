package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class for Feet
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // Same reference
            if (this == obj) return true;

            // Null or different class
            if (obj == null || getClass() != obj.getClass()) return false;

            // Type cast
            Feet other = (Feet) obj;

            // Safe double comparison
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Optional main (for demo, not required in TDD)
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Equal: " + f1.equals(f2));
    }
}