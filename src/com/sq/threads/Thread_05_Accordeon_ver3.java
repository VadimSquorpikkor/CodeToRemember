package com.sq.threads;

/**
 * Created by VadimSquorpikkor on 03.04.2017.
 */
public class Thread_05_Accordeon_ver3 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Runnable runnable1 = new PrintRunnable("A", 200);
            Thread thread1 = new Thread(runnable1);
            thread1.start();
            Runnable runnable2 = new PrintRunnable("    B", 199);
            Thread thread2 = new Thread(runnable2);
            thread2.start();
            thread1.join();
            thread2.join();


            System.out.println("------");
            Runnable runnable3 = new PrintRunnable("  C  ", 200);
            runnable3.run();
            System.out.println("------");

        }
    }
}
