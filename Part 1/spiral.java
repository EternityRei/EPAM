package com.epam.rd.autotasks;


class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int s = 1;
        int i, k = 0, l = 0;
        int m = rows;
        int n = columns;

        while(k < m && l < n){
            for (i = l; i < n; ++i) {
                array[k][i] = s++;
            }
            k++;
            for (i = k; i < m; ++i) {
                array[i][n - 1] = s++;
            }
            n--;

            if(k < m){
                for(i = n - 1; i >= l; --i){
                    array[m - 1][i] = s++;
                }
                m--;
            }
            if(l < n){
                for (i = m - 1; i >= k; --i){
                    array[i][l] = s++;
                }
                l++;
            }
        }
        return array;
    }
}
