package test.thread.throwExceptionNoLock;

public class Service {

    synchronized public void test() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("Thread name : " + Thread.currentThread().getName());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("Thread name : " + Thread.currentThread().getName());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread name : " + Thread.currentThread().getName());
        }
    }
}
