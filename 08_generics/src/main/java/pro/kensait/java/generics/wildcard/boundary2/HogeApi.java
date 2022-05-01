package pro.kensait.java.generics.wildcard.boundary2;

public class HogeApi {

    public void process1(Foo<? extends Number> foo) {
        System.out.println(foo.getProperty());
    }

    public void process2(Foo<? super Integer> foo) {
        System.out.println(foo.getProperty());
    }
}