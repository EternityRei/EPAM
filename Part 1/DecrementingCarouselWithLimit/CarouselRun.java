package com.epam.rd.autotasks;

public class CarouselRun {
    private final int[] storage;
    private int index;
    private boolean isFinished;
    private final DecrementingCarousel carousel;
    private int action;

    DecrementingCarouselWithLimitedRun dl;



    public CarouselRun(int[] storage, DecrementingCarousel carousel){
        this.storage = storage;
        this.carousel = carousel;
        if(storage.length == 0 || storage[index] == 0)
            isFinished = true;
    }

    public void setNextIndex(){
        int count = 0;
        do{
            count++;
            index = (index + 1) % storage.length;
            action++;
                if (storage[index] != 0) {
                    return;
                }
            if(action == dl.getActionLimit()){
                break;
            }
        } while(count <= storage.length);
        isFinished = true;
        index = -1;
    }

    public int next(){
        if(isFinished){
            return -1;
        } else {
            int element = storage[index];
            storage[index] = carousel.modifyElement(storage[index]);
            setNextIndex();
            return element;
        }
    }

    public boolean isFinished(){
        return isFinished;
    }

}
