package test.thread.yield;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new YieldThread()).start();
        }
//        for (int i = 0; i < 10; i++) {
//            new YieldThread();
//        }
    }
}
