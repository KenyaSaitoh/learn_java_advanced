package pro.kensait.java.generics2.wildcard.case3;

public class GenericsMain4 {

    public static void main(String[] args) {

        HogeApi hoge = new HogeApi();

        Foo<Integer> foo1 = new Foo<>(100);

        hoge.process1(foo1);

        Foo<Number> foo2 = new Foo<>(100);
        hoge.process2(foo2);
    }
}