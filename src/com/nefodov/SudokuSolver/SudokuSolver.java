package com.nefodov.SudokuSolver;

import java.util.Arrays;

public class SudokuSolver {

    public static int[][] sudoku(int[][] puzzle) {
        int[] counts = updateQuantity(puzzle);
        int curr = 1;

        while (Arrays.stream(counts).sum() != 81) {
            if (curr > 9) curr = 1;

            //mark invalid positions
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (puzzle[i][j] == curr) {
                        for (int k = 0; k < 9; k++) {
                            if (puzzle[k][j] == 0) puzzle[k][j] = -1;
                            if (puzzle[i][k] == 0) puzzle[i][k] = -1;
                        }
                        if (i / 3 == 0) {
                            if (j / 3 == 0) {
                                updateSquare(puzzle, 0, 0, 3, 3);
                            } else if (j / 3 == 1) {
                                updateSquare(puzzle, 0, 3, 3, 6);
                            } else {
                                updateSquare(puzzle, 0, 6, 3, 9);
                            }
                        } else if (i / 3 == 1) {
                            if (j / 3 == 0) {
                                updateSquare(puzzle, 3, 0, 6, 3);
                            } else if (j / 3 == 1) {
                                updateSquare(puzzle, 3, 3, 6, 6);
                            } else {
                                updateSquare(puzzle, 3, 6, 6, 9);
                            }
                        } else {
                            if (j / 3 == 0) {
                                updateSquare(puzzle, 6, 0, 9, 3);
                            } else if (j / 3 == 1) {
                                updateSquare(puzzle, 6, 3, 9, 6);
                            } else {
                                updateSquare(puzzle, 6, 6, 9, 9);
                            }
                        }
                    }
                }
            }

            //update single 0 in squares
            updateSquare(puzzle, curr);

            //return 0 to all empty places
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (puzzle[i][j] == -1) puzzle[i][j] = 0;
                }
            }

            //update current checked number
            curr++;
            //recalculate amount of numbers
            counts = updateQuantity(puzzle);
        }

        return puzzle;
    }

    //calculate quantity of numbers
    private static int[] updateQuantity(int[][] matrix) {
        int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) if (matrix[i][j] != 0) counts[matrix[i][j] - 1]++;
        return counts;
    }

    private static void updateSquare(int[][] matrix, int i, int jStart, int iMax, int jMax) {
        for (; i < iMax; i++) {
            for (int j = jStart; j < jMax; j++) {
                if (matrix[i][j] == 0) matrix[i][j] = -1;
            }
        }
    }

    private static void updateSquare(int[][] matrix, int curr) {
        int cnt = 0, posI = -1, posJ = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;

        cnt = 0;
        posI = -1;
        posJ = -1;
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    posI = i;
                    posJ = j;
                }
            }
        }
        if (cnt == 1) matrix[posI][posJ] = curr;
    }
}