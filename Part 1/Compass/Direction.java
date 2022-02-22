package com.epam.rd.autotasks;

public enum Direction {
    N(0),
    NE(45),
    E(90),
    SE(135),
    S(180),
    SW(225),
    W(270),
    NW(315);


    Direction(final int degrees) {
        this.degrees = degrees;
    }
    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        for(Direction direction: Direction.values()){
            if(degrees == direction.degrees || degrees % 360 == direction.degrees || degrees + 360 == direction.degrees)
                return direction;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int mod = degrees % 360;
        mod+=14;
        for(Direction direction: Direction.values()){
            if(degrees == direction.degrees || degrees % 360 == direction.degrees || degrees + 360 == direction.degrees ||
            degrees + 1 == direction.degrees || degrees - 20 == direction.degrees || degrees + 20 == direction.degrees ||
            mod == direction.degrees)
                return direction;
        }
        return null;
    }

    public Direction opposite() {
        int degrees = this.getDegrees();
        degrees+=180;
        if(degrees == 360)
            return N;
        if(degrees > 360)
            degrees-=360;
        for(Direction direction: Direction.values()){
            if(degrees == direction.getDegrees())
                return direction;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        int dif;
        if(this.degrees >= direction.degrees){
            dif = this.degrees - direction.degrees;
            if(dif > 180){
                dif = dif % 360;
                if(dif > 180)
                    dif = Math.abs((dif - 360));
            }
            return dif;
        }
        else {
            dif = direction.degrees - this.degrees;
            if(dif > 180){
                dif = dif % 360;
                if(dif > 180)
                    dif = Math.abs((dif - 360));
            }
            return dif;
        }
    }

    public int getDegrees() {
        return degrees;
    }
}
