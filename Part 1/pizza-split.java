package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner console = new Scanner(System.in);
        int people = console.nextInt();
        int pieces = console.nextInt();

        System.out.println(Lcm(people, pieces) / pieces);


    }
    public static int Gcd(int people, int pieces){
        if (people % pieces == 0)
            return pieces;
        if (pieces % people == 0)
            return people;
        if (people > pieces)
            return Gcd(people % pieces, pieces);
        return Gcd(people, pieces % people);
    }
    public static int Lcm(int people, int pieces){
        return ((people * pieces)/Gcd(people, pieces));
    }
}
