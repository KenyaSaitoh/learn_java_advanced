package pro.kensait.java.advanced.lesson8_2_2;

public class FooImpl implements Foo {
    //
    public int doSomething(int param) {
        System.out.println("[ FooImpl#doSomething ] Start");
        System.out.println("[ FooImpl#doSomething ] param => " + param);
        System.out.println("[ FooImpl#doSomething ] End");
        return param + param;
    }
}