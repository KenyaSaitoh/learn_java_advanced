package pro.kensait.java.advanced.generics.type.classs;

public class Foo<T> {
    private T property;
    private T property2;
    
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

    public T getProperty2() {
        return property2;
    }

    public void setProperty2(Object property) {
        this.property2 = (T)property2;
    }
}