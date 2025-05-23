package com.nefodov.TwiceLinear;

import java.util.HashSet;
import java.util.PriorityQueue;

public class DoubleLinear {

    public static int dblLinear (int n) {
        HashSet<Integer> foundValues = new HashSet<>();
        PriorityQueue<Integer> seq = new PriorityQueue<>();

        seq.add(1);
        foundValues.add(1);

        for(int i = 0; i < n; i++) {
            int x = seq.poll();
            int y = 2 * x + 1;
            int z = 3 * x + 1;

            if (!foundValues.contains(y)) {
                foundValues.add(y);
                seq.add(y);
            }

            if (!foundValues.contains(z)) {
                foundValues.add(z);
                seq.add(z);
            }
        }

        return seq.poll();
    }
}