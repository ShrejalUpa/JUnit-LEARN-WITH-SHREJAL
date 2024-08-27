package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestForMulof2Matrix {

        @Test
        public void testMatrixAdditionValid() {
            int[][] a = {{1, 2}, {3, 4}};
            int[][] b = {{5, 6}, {7, 8}};
            int[][] expected = {{6, 8}, {10, 12}};

            // Instead of returning the matrix, you could modify the add method to return the result for testing.
            int[][] result = new int[2][2];
            try {
                TestForMulof2Matrix.add(a, 2, 2, b, 2, 2);
                result = a; // Assuming add method modifies a
            } catch (Exception e) {
                fail("Addition threw an exception: " + e.getMessage());
            }

            assertArrayEquals(expected, result);
        }

        @Test
        public void testMatrixAdditionInvalid() {
            int[][] a = {{1, 2}, {3, 4}};
            int[][] b = {{5, 6, 7}, {8, 9, 10}};

            try {
                TestForMulof2Matrix.add(a, 2, 2, b, 2, 3);
                fail("Expected an IllegalArgumentException to be thrown");
            } catch (IllegalArgumentException e) {
                assertEquals("Addition not possible - Matrices must be of the same dimensions", e.getMessage());
            }
        }

    private static void add(int[][] a, int i, int i1, int[][] b, int i2, int i3) {
    }

    @Test
        public void testMatrixMultiplicationValid() {
            int[][] a = {{1, 2}, {3, 4}};
            int[][] b = {{5, 6}, {7, 8}};
            int[][] expected = {{19, 22}, {43, 50}};

            int[][] result = new int[2][2];
            try {
                TestForMulof2Matrix.multiply(a, 2, 2, b, 2, 2);
                result = a; // Assuming multiply modifies a
            } catch (Exception e) {
                fail("Multiplication threw an exception: " + e.getMessage());
            }

            assertArrayEquals(expected, result);
        }

    private static void multiply(int[][] a, int i, int i1, int[][] b, int i2, int i3) {
    }

    @Test
        public void testMatrixMultiplicationInvalid() {
            int[][] a = {{1, 2}};
            int[][] b = {{5, 6}, {7, 8}};

            try {
                TestForMulof2Matrix.multiply(a, 1, 2, b, 2, 3);
                fail("Expected an IllegalArgumentException to be thrown");
            } catch (IllegalArgumentException e) {
                assertEquals("Multiplication not possible - Wrong Input", e.getMessage());
            }
        }
    }
