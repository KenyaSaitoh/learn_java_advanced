package pro.kensait.java.generics.case4;

public class Moge {
    public <T> Hoge<T> get() {
        Hoge<T> hoge = new Hoge<T>();
        return hoge;
    }
}