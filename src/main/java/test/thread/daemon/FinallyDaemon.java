package test.thread.daemon;

import java.util.concurrent.TimeUnit;

public class FinallyDaemon implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("finally daemon start");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally execute.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new FinallyDaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("main end");
    }
}
