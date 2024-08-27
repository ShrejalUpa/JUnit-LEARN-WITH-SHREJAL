package Practice;
import java.util.Scanner;

public class multiplicationOf2Matrix {

        // Method to print a matrix
        static void printMatrix(int[][] matrix) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }

        // Method to multiply two matrices
        static void multiply(int[][] a, int r1, int c1, int[][] b, int r2, int c2) {
            if (c1 != r2) { // Check if multiplication is possible
                throw new IllegalArgumentException("Multiplication not possible - Wrong Input");
            }
            int[][] mul = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < c1; k++) {
                        mul[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            System.out.println("Multiplication of 2 matrices:");
            printMatrix(mul);
        }

        // Method to add two matrices
        static void add(int[][] a, int r1, int c1, int[][] b, int r2, int c2) {
            if (r1 != r2 || c1 != c2) {
                throw new IllegalArgumentException("Addition not possible - Matrices must be of the same dimensions");
            }
            int[][] sum = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                }
            }
            System.out.println("Sum of Matrix 1 and Matrix 2:");
            printMatrix(sum);
        }

        // Main method
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Input for Matrix 1
            System.out.println("Enter number of rows and columns of Matrix 1: ");
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int[][] a = new int[r1][c1];
            System.out.println("Enter Matrix 1 values:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            // Input for Matrix 2
            System.out.println("Enter number of rows and columns of Matrix 2: ");
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            int[][] b = new int[r2][c2];
            System.out.println("Enter Matrix 2 values:");
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            // Print matrices
            System.out.println("Matrix 1:");
            printMatrix(a);
            System.out.println("Matrix 2:");
            printMatrix(b);

            // Perform addition
            try {
                add(a, r1, c1, b, r2, c2);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Perform multiplication
            try {
                multiply(a, r1, c1, b, r2, c2);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

