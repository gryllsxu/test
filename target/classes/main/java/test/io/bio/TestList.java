package test.io.bio;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main (String[] args) {
        List<Long> orderIds = new ArrayList<Long>();
        orderIds.add(new Long(111111L));
        orderIds.add(222222L);
        orderIds.add(333333L);
        orderIds.add(444444L);

        List<Long> removeIds = new ArrayList<Long>();
        removeIds.add(new Long(111111L));
        removeIds.add(222222L);

        orderIds.removeAll(removeIds);
        System.out.println(orderIds);
    }
}
