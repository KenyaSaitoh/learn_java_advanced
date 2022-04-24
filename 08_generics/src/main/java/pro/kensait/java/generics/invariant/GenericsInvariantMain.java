package pro.kensait.java.generics.invariant;

// 非変
public class GenericsInvariantMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Hoge<Integer> hoge1 = new Hoge<Integer>();

        // 以下はコンパイルエラーになる。
        // Hoge<Number> hoge2 = hoge1;
    }
}