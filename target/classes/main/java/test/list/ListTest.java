package test.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ListTest {

    public static void main(String[] args) {
//        System.out.println(Math.ceil(1020/(999 + 0.0)));
        int j = 0;
        ArrayList<A> arrayList = new ArrayList<A>();
        List<A> linkedList = new LinkedList<A>();

        for (int i = 0; i < 5; i++) {
            arrayList.add(new A("a" + i));
//            linkedList.add(new A("a" + i));
        }
        List<A> temp = new ArrayList<A>();
        temp.addAll(arrayList.subList(0, 2));
        temp.addAll(arrayList.subList(2, arrayList.size()));
        System.out.println(temp);
//        arrayList.trimToSize();
//        for (A a : arrayList) {
//            System.out.println(a);
//        }
        
//        List<A> aList = arrayList.subList(0, 10);
//        System.out.println(aList);
//
//        Object[] objs = arrayList.toArray();
//        System.out.println(objs);

//        A a1 = new A("a1");
//        long start = System.currentTimeMillis();
//        while (j < 1000000) {
//            arrayList.remove(0);
//            arrayList.add(a1);
//            j++;
//        }
//        System.out.println(System.currentTimeMillis() - start);
//
//        j = 0;
//        start = System.currentTimeMillis();
//        while (j < 1000000) {
//            linkedList.remove(0);
//            linkedList.add(a1);
//            j++;
//        }
//        System.out.println(System.currentTimeMillis() - start);
    }
}
