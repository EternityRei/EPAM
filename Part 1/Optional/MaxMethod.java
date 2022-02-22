package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt max;
        if(values == null || values.length == 0){
            return OptionalInt.empty();
        }
        int maxValuePos = values[0];
        for (int value : values) {
            if (maxValuePos < value)
                maxValuePos = value;
        }
        max = OptionalInt.of(maxValuePos);
        return max;
    }
}
