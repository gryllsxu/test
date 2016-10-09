package test.string;

public class StringBufferTest {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("123123123,");
        sb1.delete(sb1.length() - 1, sb1.length());
        System.out.println(sb1);
//        StringBuffer sb2 = new StringBuffer();
//        String str = "";
//
//        long start = System.currentTimeMillis();
//        System.out.println(start);
//
//        stringBuilder(sb1);
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        stringBuffer(sb2);
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        string(str);
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
    }

    private static void stringBuilder(StringBuilder sb) {
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
    }

    private static void stringBuffer(StringBuffer sb) {
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
    }

    private static void string(String sb) {
        for (int i = 0; i < 10000; i++) {
            sb += i;
        }
    }
}
