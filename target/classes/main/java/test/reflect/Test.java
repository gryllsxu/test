package test.reflect;

public class Test {

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("test.reflect.TestI");
        System.out.println(c);
    }
}
