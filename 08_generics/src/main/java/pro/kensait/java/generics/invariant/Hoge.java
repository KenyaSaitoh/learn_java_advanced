package pro.kensait.java.generics.invariant;

public class Hoge<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}