package com.company;

import java.util.Scanner;

public class Main {

    private int decrease;

    public int modifyValue(int val){
        modifyDecrease(decrease);
        if(val > 0) {
            int dec = decrease;
            val = val - decrease;
        } return val;
    }

    int modifyDecrease(int decrease){
        this.decrease = decrease++;
        return decrease;
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int val = con.nextInt();
    }
}
