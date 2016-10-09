package test.thread.inner;

public class InnerThread1 {

    private int countDown = 5;
    private Inner inner = null;

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDown == 0) {
                    return;
                }
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
//        inner = new Inner();
    }

    public static void main(String[] args) {
        InnerThread1 it1 = new InnerThread1("innerThread1");
        System.out.println(it1.inner);
    }
}
