package pro.kensait.java.generics2.case3;

public class GenericsMain4 {

    public static void main(String[] args) {
        Foo<Integer> foo = new Foo<>(100);
        Hoge hoge = new Hoge();
        hoge.execute(foo);
    }
}