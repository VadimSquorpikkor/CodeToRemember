package com.sq.threads;

  /** Created by VadimSquorpikkor on 03.04.2017.*/

public class Thread_01 {
    public static void main(String[] args) throws InterruptedException{
      Runnable runnable = new PrintRunnable("B", 1000);
      Thread thread = new Thread(runnable);
      thread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            System.out.println("A");
        }
    }
}
