package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int average;
        int key = 0;
        int sum = 0;
        for(int i = num; i!=0; i = scanner.nextInt()){
            sum += i;
            key++;
        }
        average = sum/key;
        System.out.println(average);

    }
}
