package com.epam.rd.autotasks;

public class DecrementingCarousel {

    private boolean isRun = false;
    private final ArrayNums nums;
    private int decrementPosition = 0;

    public DecrementingCarousel(int capacity) {
        this.nums = new ArrayNums(capacity);
    }

    public boolean addElement(int element){
        if(isRun || element <= 0)
            return false;
        return nums.addElement(element);
    }

    public CarouselRun run(){
        if(!isRun) {
            isRun = true;
            return new CarouselRun(this);
        }
        return null;
    }

    public int getNextDecrementPosition(){
        if(decrementPosition >= nums.getCarousel().length)
            decrementPosition = 0;
        return decrementPosition++;
    }

    public void setDecrementPosition(int decrementPosition) {
        this.decrementPosition = decrementPosition;
    }

    public ArrayNums getNums() {
        return nums;
    }
}

class ArrayNums{
    private int[] carousel;
    private int count = 0;

    public ArrayNums(int capacity) {
        this.carousel = new int[capacity];
    }

    public boolean addElement(int element){
        if (carousel.length > count){
            carousel[count++] = element;
            return true;
        }
        return false;
    }

    public void removeElementByIndex(int index){
        int[] newCarousel = new int[carousel.length-1];
        int n = 0;
        for (int i = 0; i < newCarousel.length; i++) {
            if(n == index)
                n++;
            newCarousel[i] = carousel[n++];
        }
        carousel = newCarousel;
    }

    public int getElement(int index){
        return carousel[index];
    }

    public int getCount(){
        return count;
    }

    public int[] getCarousel(){
        return carousel;
    }

    public void minusElement(int index){
        carousel[index]--;
    }
}
