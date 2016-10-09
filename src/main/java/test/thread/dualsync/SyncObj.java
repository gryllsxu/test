package test.thread.dualsync;

public class SyncObj {

    public static void main(String[] args) {
        final DualSync ds = new DualSync();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
