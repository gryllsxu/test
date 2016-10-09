package test.thread.test1;

public class CountDown implements Runnable {

    private int num = 10;

    @Override
    public void run() {
        while (num-- > 0) {
            print();
        }
    }

    private void print() {
        System.out.println("num: " + num);
    }
}
