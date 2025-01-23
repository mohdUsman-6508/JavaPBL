package JavaBasics;

import java.util.Scanner;

public class MatrixMultiplication {

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length;
        int r2 = B.length, c2 = B[0].length;
        int[][] result = new int[r1][c2];

        if (c1 != r2) {
            System.out.println("Matrix Multiplication is not possible.");
            return new int[0][0];
        }

        for (int k = 0; k < A.length; k++) {
            int[] row = A[k];
            for (int i = 0; i < B[0].length; i++) {
                int mul = 0;
                for (int j = 0; j < B.length; j++) {
                    mul += row[j] * B[j][i];
                }
                result[k][i] = mul;
            }
        }

        return result;
    }

    static void print(int[][] C) {
        System.out.println("-------Result-------");
        System.out.println("--------------------");
        for (int[] row : C) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }


    public static void main(String[] args) {

        System.out.println("Welcome!");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----------Matrix Multiplication----------");
            System.out.println("Enter dimensions(rows,cols)  of first matrix: ");
            int r1 = sc.nextInt();
            sc.nextLine();
            int c1 = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter dimensions(rows,cols)  of second matrix: ");
            int r2 = sc.nextInt();
            sc.nextLine();
            int c2 = sc.nextInt();
            sc.nextLine();

            int[][] A = new int[r1][c1];
            int[][] B = new int[c1][r2];

            if (c2 != r2) {
                System.out.println("Matrix Multiplication not possible( cols of first matrix should be equal to rows of second matrix");
                return;
            }

            System.out.println("Enter (m*n) elements of first matrix: ");
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] = sc.nextInt();
                    sc.nextLine();
                }
            }

            System.out.println("Enter (m*n) elements of second matrix: ");
            for (int i = 0; i < B.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    B[i][j] = sc.nextInt();
                    sc.nextLine();
                }
            }

            int[][] result = matrixMultiplication(A, B);
            print(result);

            System.out.println("To calculate more enter 1");
            int toContinue = sc.nextInt();
            sc.nextLine();

            if (toContinue != 1) {
                System.out.println("Thanks for using our app:)");
                break;
            }
        }

    }
}
