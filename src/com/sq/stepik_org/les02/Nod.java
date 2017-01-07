package com.sq.stepik_org.les02; // Created by SquorpikkoR on 07.01.2017.

import java.util.Scanner;

        /*По данным двум числам 1≤a,b≤2⋅10_9
        найдите их наибольший общий делитель.

        Sample Input 1: 18 35
        Sample Output 1: 1

        Sample Input 2: 14159572 63967072
        Sample Output 2: 4*/

public class Nod {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(nod(a,b));
    }

    public static int nod(int ch, int zn){//НОД для дроби
        int a = ch;     // делаю копию дроби, чтоб
        int b = zn;     // не портить исходную
        int c;
        if(a>b){
            a = a + b;      //Если числитель больше
            b = (a - b);    //знаменателя, то дробь переворачивается
            a = a - b;      //(исходная дробь не меняется)
        }
        do{                 //Нахождение НОД по Евклиду
            c = b % a;
            if(c == 0){break;}
            b = a;
            a = c;
        }
        while(a > 1);
        return a;
    }
}
