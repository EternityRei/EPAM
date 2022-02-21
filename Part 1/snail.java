package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int h = console.nextInt();
        int numberOfDays = 0;
        if(a == b && a > h){
            numberOfDays++;
            System.out.println(numberOfDays);
        } else if(a == b && a < h){
            System.out.println("Impossible");
        } else if(a < b && a < h){
            System.out.println("Impossible");
        } else {
            for(int upReal = 0; upReal < h; numberOfDays++)
                upReal = (a - b) * numberOfDays + a;
            System.out.println(numberOfDays);
        }
    }
}
