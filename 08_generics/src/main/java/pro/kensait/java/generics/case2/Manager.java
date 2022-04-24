package pro.kensait.java.generics.case2;

public class Manager {
    public <T> T narrow(Object obj, Class<T> clazz) {
        return clazz.cast(obj);
    }
}