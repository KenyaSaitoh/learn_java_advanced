package pro.kensait.java.generics2.type.interfaces;

public class GenericsIFMain1 {

    public static void main(String[] args) {

        FooInterface<String> foo1 = new Foo<String>();
        foo1.setProperty("Foo");
        String str = foo1.getProperty();
        System.out.println(str);


        FooInterface<Integer> foo2 = new Foo<Integer>();
        foo2.setProperty(100);
        int num = foo2.getProperty();
        System.out.println(num);
    }
}