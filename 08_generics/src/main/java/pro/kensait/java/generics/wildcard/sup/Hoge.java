package pro.kensait.java.generics.wildcard.sup;

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