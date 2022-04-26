package pro.kensait.java.generics2.wildcard.case1;

public class GenericsMain2 {
    public static void main(String[] args) {
        Foo<Integer> foo1 = new Foo<Integer>();
        Foo<?> foo2 = foo1;
        
        // 以下はコンパイルエラー
        // Foo<Integer> foo3 = foo2;
    }
}