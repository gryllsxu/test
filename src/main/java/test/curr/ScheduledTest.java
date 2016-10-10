package test.curr;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new ScheduledRunnable(), 10, TimeUnit.SECONDS);
        System.out.println("ScheduledTest sta --- " + System.currentTimeMillis());
        scheduledExecutorService.shutdown();
        System.out.println("ScheduledTest end --- " + System.currentTimeMillis());
    }

    public static class ScheduledRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("ScheduledRunnable --- " + System.currentTimeMillis());
        }
    }
}
