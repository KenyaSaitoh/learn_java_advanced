package pro.kensait.java.generics.case4;

public class Hoge<T> {
    private T object;

    public Hoge() {
    }

    public Hoge(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}