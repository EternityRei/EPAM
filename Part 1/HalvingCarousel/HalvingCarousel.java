package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity){
        super(capacity);
    }

    @Override
    int modifyElement(int val){
        return val / 2;
    }
}
