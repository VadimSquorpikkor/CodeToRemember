package com.sq.stepik_org.les06; // Created by SquorpikkoR on 16.01.2017.

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class PAndL_Generator {
    public static void main(String[] args) throws FileNotFoundException {
        new PAndL_Generator().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("src/com/sq/stepik_org/les06/point_data.txt");
        int n = 5000;
        printWriter.println(n + " " + n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num1 = random.nextInt(10000);
            int num2 = random.nextInt(10000) + num1;
            printWriter.println(num1 + " " + num2);
        }
        for (int i = 0; i < n; i++) {
            int point = random.nextInt(10000);
            printWriter.print(point + " ");
        }
        printWriter.close();
    }

}
