package pro.kensait.java.generics.wildcard.ext;

// 有界ワイルドカード（上限境界）
public class WildcardExtendsMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Hoge<Integer> hoge1 = new Hoge<Integer>();
        Hoge<? extends Number> hoge2 = hoge1;

        // Number型の値を取得することができる。
        // つまり、値を取得する場合は共変のように振る舞う。
        Number value = hoge2.getObject();

        // Integer型の値をセットすることはできない（コンパイルエラー）。
        // hoge2.setObject(new Integer(10));
    }
}