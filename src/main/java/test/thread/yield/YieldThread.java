package test.thread.yield;

import java.util.concurrent.ThreadFactory;

public class YieldThread implements Runnable {
    private static int num = 0;
    private final int version = num++;

    public YieldThread() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + version + " construct.");
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + " run.");
        Thread.yield();
        Thread.yield();
        Thread.yield();
        System.out.println("Thread name: " + Thread.currentThread().getName() + " end.");
    }

}
