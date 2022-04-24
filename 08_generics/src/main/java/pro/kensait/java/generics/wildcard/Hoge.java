package pro.kensait.java.generics.wildcard;

public class Hoge<T> {
    private T object;

    public Hoge() {
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}