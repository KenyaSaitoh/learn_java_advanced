package pro.kensait.java.advanced.lesson8_1_3.inheritence;

public class MyContainer<T> implements MyContainerIF<T> {
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