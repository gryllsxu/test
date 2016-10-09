package test.thread.test1;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new CountDown());
        t.start();
        System.out.println("wait for count down");
        Thread.sleep(1000);
        System.out.println("end of count down");
    }
}
