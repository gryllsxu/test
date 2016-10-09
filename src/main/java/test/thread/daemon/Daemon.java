package test.thread.daemon;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("finally daemon start" + this);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally execute.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Daemon());
            t.setDaemon(true);
            t.start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main end");
    }
}
