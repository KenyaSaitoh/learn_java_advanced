package pro.kensait.java.generics2.case1;

public class Foo<T> {
    private T target;

    public Foo() {
        // 総称型は、newでオブジェクトを生成できない。
        // object = new T;
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