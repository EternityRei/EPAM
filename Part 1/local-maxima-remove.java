package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int[] arrayCopy = new int[array.length + 1];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        arrayCopy[array.length] = 0;
        array = arrayCopy;
        int[] arrayCopy2 = new int[array.length + 1];
        System.arraycopy(array, 0, arrayCopy2, 1, array.length);
        arrayCopy2[0] = 0;
        array = arrayCopy2;

        for (int i = 1; i < array.length - 1; i++) {
            if ((array[i] > array[i - 1]) && (array[i] > array[i + 1])) {
                int[] copy = new int[array.length - 1];
                for (int k = 0, j = 0; k < array.length; k++) {
                    if (k != i) {
                        copy[j++] = array[k];
                    }
                }
                array = copy;
            }
        }

        int[] tempArray = new int[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == 0) {
                continue;
            }
            tempArray[k++] = array[i];
        }
        array = tempArray;

        int[] finalArray = new int[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                continue;
            }
            finalArray[k++] = array[i];
        }
        array = finalArray;

        return array;

    }
}
