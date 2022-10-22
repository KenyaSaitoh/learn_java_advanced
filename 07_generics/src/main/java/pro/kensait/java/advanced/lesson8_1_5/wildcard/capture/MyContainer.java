package pro.kensait.java.advanced.lesson8_1_5.wildcard.capture;

public class MyContainer<T> {
    private T property;
    public MyContainer(T property) {
        this.property = property;
    }
    public T getProperty() {
        return property;
    }
    public void setProperty(T property) {
        this.property = property;
    }
}