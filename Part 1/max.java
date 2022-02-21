package com.epam.rd.autotasks.max;


public class MaxMethod {

    public static int max(int[] values) {
        int max1 = values[0];
        for (int i = 0; i < values.length; i++) {
            if(values[i] > max1)
                max1 = values[i];
        }
        return max1;
    }
}
