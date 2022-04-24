package pro.kensait.java.generics2.case4;

public class Foo<T> {
    private T target;

    public Foo() {
    }

    public Foo(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}