package com.epam.rd.autotasks;

public class CarouselRun {

    private DecrementingCarousel dc;

    public CarouselRun(DecrementingCarousel dc) {
        this.dc = dc;
    }

    public int next() {
        if(!isFinished()){
            int dp = dc.getNextDecrementPosition();
            int val = dc.getNums().getElement(dp);
            if(val == 0){
                dc.getNums().removeElementByIndex(dp);
                dc.setDecrementPosition(dp);
                return next();
            }
            dc.getNums().minusElement(dp);
            return val;
        }
        return -1;
    }

    public boolean isFinished() {
        if(dc.getNums().getCount() == 0 || dc.getNums().getCarousel().length == 0){
            return true;
        }
        for(int i : dc.getNums().getCarousel()){
            if (i != 0)
                return false;
        }
        return true;
    }

}
