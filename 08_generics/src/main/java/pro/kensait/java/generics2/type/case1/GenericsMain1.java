package pro.kensait.java.generics2.type.case1;

public class GenericsMain1 {

    public static void main(String[] args) {

        Foo<String> foo1 = new Foo<String>();
        foo1.setProperty("Foo");
        String str = foo1.getProperty();
        System.out.println(str);


        Foo<Integer> foo2 = new Foo<Integer>();
        foo2.setProperty(100);
        int num = foo2.getProperty();
        System.out.println(num);


        // 型変数に関連した不変式が破壊されてしまうケース
        // Foo<Integer> foo3 = new Foo<Integer>();
        // foo3.setProperty2("A");
        // String str = foo3.getProperty2();
    }
}