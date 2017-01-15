package com.sq.stepik_org.les03; // Created by SquorpikkoR on 14.01.2017.

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class StrokeGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        new StrokeGenerator().run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input.txt");
        int n = 100;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            printWriter.print((char)('a' + random.nextInt(26)));
        }
        printWriter.close();
    }
}
