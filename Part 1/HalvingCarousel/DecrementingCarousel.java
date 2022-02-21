package com.epam.rd.autotasks;

public class DecrementingCarousel{
    private final int[] storage;
    private int index;
    private boolean isRun;

    public DecrementingCarousel(int capacity){
        storage = new int[capacity];
    }

    public boolean addElement(int element){
        if(element <= 0 || storage.length == index || isRun){
            return false;
        }
        storage[index++] = element;
        return true;
    }

    int modifyElement(int val){
        return --val;
    }

    public CarouselRun run(){
        if(isRun){
            return null;
        } else {
            isRun = true;
            return new CarouselRun(storage, this);
        }
    }
}


