package pro.kensait.java.advanced.lsn_8_1_2.generictype;

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