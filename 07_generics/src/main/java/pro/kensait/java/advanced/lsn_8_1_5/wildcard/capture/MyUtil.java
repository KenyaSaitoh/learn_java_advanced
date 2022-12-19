package pro.kensait.java.advanced.lsn_8_1_5.wildcard.capture;

public class MyUtil {
    public <T> void printProperty1(MyContainer<T> container) {
        System.out.println(container.getProperty());
    }

    public <T> void printProperty2(MyContainer<T> container, T t) {
        container.setProperty(t);
        System.out.println(container.getProperty());
    }
}