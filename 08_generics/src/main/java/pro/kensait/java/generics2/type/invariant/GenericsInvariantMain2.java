package pro.kensait.java.generics2.type.invariant;

// 非変
public class GenericsInvariantMain2 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Foo<Integer> foo1 = new Foo<Integer>();

        // 以下はコンパイルエラーになる
        // Foo<Number> hoge2 = hoge1;
    }
}