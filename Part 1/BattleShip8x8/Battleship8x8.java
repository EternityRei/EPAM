package com.epam.rd.autotasks;

import java.util.Arrays;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        char[] ch = new char[shot.length()];
        for (int i = 0; i < shot.length(); i++) {
            ch[i] = shot.charAt(i);
        }
        int column = 0;
        switch (ch[0]){
            case 'A': column = 1; break;
            case 'B': column = 2; break;
            case 'C': column = 3; break;
            case 'D': column = 4; break;
            case 'E': column = 5; break;
            case 'F': column = 6; break;
            case 'G': column = 7; break;
            case 'H': column = 8; break;
        }
        int toChange = column + (8 * (Integer.parseInt(String.valueOf(ch[1])) - 1));
        int n = 64 - toChange;
        long currentShot = 1L;
        currentShot = currentShot << n;
        shots = shots | currentShot;
        return (ships & currentShot) != 0;
}

    public String state() {
        char water = '.';
        char miss = '×';
        char ship = '☐';
        char hit = '☒';
        char[] ch1 = Long.toBinaryString(ships).toCharArray();
        if (ch1.length < 64) {
            char[] dummy = new char[64];
            Arrays.fill(dummy, '0');
            System.arraycopy(ch1, 0, dummy, 1, dummy.length - 1);
            ch1 = dummy;
            System.out.println(ch1.length + " " + Arrays.toString(ch1));
        }
        char[] ch2 = Long.toBinaryString(shots).toCharArray();
        if (ch2.length < 64){
            char[] dummy = new char[64];
            Arrays.fill(dummy, '0');
            System.arraycopy(ch2, 64 - ch2.length - (64 - ch2.length), dummy, 64 - ch2.length, dummy.length - (64 - ch2.length));
            ch2 = dummy;
            System.out.println(ch2.length + " " + Arrays.toString(ch2));
        }
        char[] ch3 = new char[64];
        for (int i = 0; i <= ch1.length-1; i++){
            if (ch1[i] == '1' && ch2[i] == '1') {
                ch3[i] = hit;
            }
            if (ch1[i] == '1' && ch2[i] == '0') {
                ch3[i] = ship;
            }
            if (ch1[i] == '0' && ch2[i] == '1') {
                ch3[i] = miss;
            }
            if (ch1[i] == '0' && ch2[i] == '0') {
                ch3[i] = water;
            }
        }
        String str = String.valueOf(ch3);
        for (int i = 8; i < ch3.length; i=i+8+1){
            str = str.substring(0, i) + '\n' + str.substring(i);
        }
        return str;
    }
}
