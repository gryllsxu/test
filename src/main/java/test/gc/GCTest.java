package test.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * GC
 * -XX:+UseSerialGC
 * -XX:+UseParallelGC
 * -XX:+UseConcMarkSweepGC
 * -XX:ParallelCMSThreads=2
 * -XX:ParallelCMSThreads=4
 * -XX:+UseG1GC
 *
 * Created by grylls on 2018/1/12.
 */
public class GCTest {

    private static Map<String, byte[]> map = new HashMap<String, byte[]>();

    public static void main (String[] args) {
        before();

        for (int i = 1; i <= 200; i++) {
            add();
        }

    }

    private static void add() {
        byte[] a1, a2;
        a1 = new byte[2 * 1024 * 1024];
//        a2 = new byte[2 * 1024 * 1024];

//        map.remove("a1");
//        if (a1.length != map.get("a1").length) {
//
//        }
        byte[] tmp = map.get("a1");
        map.put("a1", a1);
//        map.put("a2", a2);
        tmp = null;
//        System.gc();
    }

    private static void before() {
        byte[] a1, a2;
        a1 = new byte[2 * 1024 * 1024];
        a2 = new byte[2 * 1024 * 1024];
//        a3 = new byte[2 * 1024 * 1024];

        map.put("a1", a1);
        map.put("a2", a2);
//        map.put("a3", a3);
    }


//    byte[] a1, a2, a3, a4;
//    a1 = new byte[2 * 1024 * 1024];
//    a2 = new byte[2 * 1024 * 1024];
//    a3 = new byte[2 * 1024 * 1024];
//    a4 = new byte[2 * 1024 * 1024];
//
//        map.put("a1", a1);
//        map.put("a2", a2);
//        map.put("a3", a3);
//        map.put("a4", a4);
}
