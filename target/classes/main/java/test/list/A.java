package test.list;

public class A {

    public A() {
        
    }
    public A (String a) {
        this.a = a;
    }

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String toString() {
        return "a: " + a;
    }
}
