package com.nefodov.Snail;

public class Snail {
    public static int[] snail(int[][] array) {
        int[] snail = new int[array.length * array.length];
        int i = 0, j = 0, k = 0, c = 0;
        if (array.length != 0 && array[0].length == 0) {
            return new int[0];
        }
        while (k < snail.length) {
            for (; k < snail.length && j < array.length - c; j++) {
                snail[k] = array[i][j];
                k++;
            }
            for (i++, j--; k < snail.length && i < array.length - c; i++) {
                snail[k] = array[i][j];
                k++;
            }
            for (i--, j--; k < snail.length && j >= c; j--) {
                snail[k] = array[i][j];
                k++;
            }
            for (i--, j++, c++; k < snail.length && i >= c; i--) {
                snail[k] = array[i][j];
                k++;
            }
            i++;
            j++;
        }
        return snail;
    }
}
