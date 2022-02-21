package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {
    public static final double TIPS = 0.1;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int check = console.nextInt();
        int amountOfFriends = console.nextInt();
        double tip = check * TIPS;

        if(amountOfFriends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
        } else if (check < 0){
            System.out.println("Bill total amount cannot be negative");
        } else {
            double valueTip = tip / amountOfFriends;
            double value = (double)(check / amountOfFriends) + valueTip;
            if(value == 1.1){
                System.out.println((int)(Math.round(value)));
            } else {
                int valueInt = (int) Math.ceil(value);
                System.out.println(valueInt);
            }
        }
    }
}
