package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        int amount = console.nextInt();
        if(amount == 0)
            System.out.println("Oh, it looks like there is no one here");
        else if(amount < 0)
            System.out.println("Seriously? Why so negative?");
        else {
            console.nextLine();
            String[] names = new String[amount];
            for (int i = 0; i < names.length; i++) {
                String name = console.nextLine();
                names[i] = name;
            }
            for (String name : names) {
                System.out.println("Hello, " + name);
            }
        }
    }
}
