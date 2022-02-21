package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner console = new Scanner(System.in);
        int max = console.nextInt();
        for(int i = max; i != 0; i = console.nextInt()){
            if(i > max) max = i;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        max();

        System.out.println(max());
    }
}
