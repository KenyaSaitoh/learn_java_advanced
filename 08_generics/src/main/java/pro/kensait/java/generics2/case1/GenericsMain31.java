package pro.kensait.java.generics2.case1;

public class GenericsMain31 {

    public static void main(String[] args) {

        Foo<String> foo1 = new Foo<String>();
        foo1.setTarget("Foo");
        String str = foo1.getTarget();
        System.out.println(str);

        
        Foo<Integer> foo2 = new Foo<Integer>();
        foo2.setTarget(100);
        int num = foo2.getTarget();
        System.out.println(num);
    }
}