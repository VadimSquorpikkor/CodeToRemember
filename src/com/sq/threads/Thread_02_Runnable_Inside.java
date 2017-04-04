package com.sq.threads;

/**Created by VadimSquorpikkor on 03.04.2017.*/

public class Thread_02_Runnable_Inside {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("A");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        );
        thread.start();

    }

}
