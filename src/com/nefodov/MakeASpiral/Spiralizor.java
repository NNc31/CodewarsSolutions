package com.nefodov.MakeASpiral;

public class Spiralizor {
    public static int[][] spiralize(int size) {
        int[][] spiral = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                spiral[i][j] = 0;
            }
        }
        int indent, i, j, steps;
        indent = 0;
        j = 0;
        steps = 0;

        while (true) {
            for (steps = 0, i = indent; j < size - indent; j++) {
                steps++;
                spiral[i][j] = 1;
            }

            if (steps <= 2 || spiral[i + 2][size - indent - 1] == 1) break;
            for (steps = 0, j = size - indent - 1; i < size - indent; i++) {
                steps++;
                spiral[i][j] = 1;
            }

            if (steps <= 2 || spiral[size - indent - 1][j - 2] == 1) break;
            for (steps = 0, i = size - indent - 1; j >= indent; j--) {
                steps++;
                spiral[i][j] = 1;
            }

            indent += 2;
            if (steps <= 2 || spiral[i - 2][indent - 2] == 1) break;
            for (steps = 0, j = indent - 2; i >= indent; i--) {
                steps++;
                spiral[i][j] = 1;
            }
            if (steps <= 2 || spiral[indent][j + 2] == 1) break;
        }

        return spiral;
    }

}
