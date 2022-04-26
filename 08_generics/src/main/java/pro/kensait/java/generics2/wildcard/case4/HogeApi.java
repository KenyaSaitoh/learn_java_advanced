package pro.kensait.java.generics2.wildcard.case4;

public class HogeApi {
    public <T> void printProperty1(Foo<T> foo) {
        System.out.println(foo.getProperty());
    }

    public <T> void printProperty2(Foo<T> foo, T t) {
        foo.setProperty(t);
        System.out.println(foo.getProperty());
    }
}