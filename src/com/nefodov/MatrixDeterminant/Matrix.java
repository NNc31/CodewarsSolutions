package com.nefodov.MatrixDeterminant;

public class Matrix {
    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        } else if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int res = 0;
            for (int i = 0; i < matrix.length; i++) {
                int sign = 1;
                if (i % 2 != 0) sign = -1;
                res += sign * matrix[0][i] * determinant(minorMatrix(matrix, i));
            }
            return res;
        }
    }

    public static int[][] minorMatrix(int[][] matrix, int n) {
        int[][] minorMatrix = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 1, im = 0; i < matrix.length; i++, im++) {
            for (int j = 0, jm = 0; j < matrix[i].length; j++) {
                if (j != n) {
                    minorMatrix[im][jm] = matrix[i][j];
                    jm++;
                }
            }
        }
        return minorMatrix;
    }
}
