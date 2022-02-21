package com.epam.rd.autotasks;

public class CarouselRun {
    private final int[] storage;
    private int index;
    private boolean isFinished;
    private final DecrementingCarousel carousel;
    private int amountOfCarousel = 1;

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
            if(!(storage[index] <= 0)){
                if(index == 0)
                    amountOfCarousel++;
                return;
            } else if(index == 0 && storage[index] <= 0 ) amountOfCarousel++;
        } while(count <= storage.length);
        isFinished = true;
        index = -1;
    }

    public int next(){
        if(isFinished){
            return -1;
        } else {
            int element = storage[index];
            storage[index] = carousel.modifyElement(storage[index], amountOfCarousel);
            setNextIndex();
            return element;
        }
    }

    public boolean isFinished(){
        return isFinished;
    }
}
