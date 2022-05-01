package pro.kensait.java.generics.type.interfaces;

public class Foo<T> implements FooInterface<T> {
    private T property;

    public Foo() {
        // 総称型は、newでオブジェクトを生成できない。
        // object = new T;
    }

    public Foo(T property) {
        this.property = property;
    }

    public T getProperty() {
        return property;
    }

    public void setProperty(T property) {
        this.property = property;
    }
}