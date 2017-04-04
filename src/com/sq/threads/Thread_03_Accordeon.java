package com.sq.threads;

/**
 * Created by VadimSquorpikkor on 03.04.2017.
 */

public class Thread_03_Accordeon {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(199);
                    System.out.println("    B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable3 = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println("  C  ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 5; i++) {
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
