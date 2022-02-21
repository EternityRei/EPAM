package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array) {
        boolean[] logic = new boolean[array.length];
        logic[0] = false;
        logic[1] = false;
        for (int i = 2; i < array.length; i++) {
            int sum = array[i - 1] + array[i - 2];
            logic[i] = sum == array[i];
        }
        return logic;
    }
}
