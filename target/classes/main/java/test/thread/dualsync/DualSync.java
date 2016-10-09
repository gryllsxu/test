package test.thread.dualsync;

import java.util.concurrent.TimeUnit;

public class DualSync {

    private Object syncObj = new Object();

    public synchronized void f() {
        for (int i = 0; i < 50; i++) {
            System.out.println("f()");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObj) {
            for (int i = 0; i < 50; i++) {
                System.out.println("g()");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
        }
    }
}
