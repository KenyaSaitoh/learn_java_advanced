package pro.kensait.java.generics2.case3;

public class Hoge {

    public void execute(Foo<? extends Number> foo) {
        System.out.println(foo.getTarget());
    }
}