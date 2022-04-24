package pro.kensait.java.generics.wildcard.capture;

public class Fuga {
    public <T> void showElement1(Hoge<T> hoge) {
        System.out.println(hoge.getObject());
    }

    public <T> void showElement2(Hoge<T> hoge, T t) {
        hoge.setObject(t);
        System.out.println(hoge.getObject());
    }
}