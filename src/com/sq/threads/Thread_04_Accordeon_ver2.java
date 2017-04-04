package com.sq.threads;

/**
 * Created by VadimSquorpikkor on 03.04.2017.
 */
public class Thread_04_Accordeon_ver2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Runnable runnable1 = new PrintRunnable("A", 200);
            Runnable runnable2 = new PrintRunnable("    B", 199);
            Runnable runnable3 = new PrintRunnable("  C  ", 200);
            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            Thread thread3 = new Thread(runnable3);

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("------");
            thread3.start();
            thread3.join();
            System.out.println("------");

        }
    }
}
