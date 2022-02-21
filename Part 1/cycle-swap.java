package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if(array.length == 0)
            array = array;
        else{
            int temp = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
    }

    static void cycleSwap(int[] array, int shift) {
        for (int i = 0; i < shift; i++) {
            cycleSwap(array);
        }
        System.out.println(Arrays.toString(array));
    }
}

