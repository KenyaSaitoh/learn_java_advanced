package pro.kensait.java.advanced.lesson8_2_3;

public class Main_DynamicProxy {
    public static void main(String[] args) {

        // Foo呼び出し
        System.out.println("[ ProxyClient ] ##### Start Foo #####");
        Foo foo = ProxyFactory.getProxy(FooImpl.class);
        int answer1 = foo.doSomething(3);
        System.out.println("[ ProxyClient ] answer1 => " + answer1);

        // Bar呼び出し
        System.out.println("[ ProxyClient ] ##### Start Bar #####");
        Bar bar = ProxyFactory.getProxy(BarImpl.class);
        int answer2 = bar.doSomething(10);
        System.out.println("[ ProxyClient ] answer2 => " + answer2);
    }
}