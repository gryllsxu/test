package test;

import java.io.Serializable;


public class A {
    B b;
    public B getB() {
        return b;
    }
    public static void main(String[] args) {
        B b2 = new A().getB();
    }
}
class B{
    public void test() {}
}

