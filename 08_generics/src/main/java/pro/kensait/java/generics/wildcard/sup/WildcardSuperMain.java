package pro.kensait.java.generics.wildcard.sup;

// 有界ワイルドカード（下限境界）
public class WildcardSuperMain {
    public static void main(String[] args) {

        Hoge<Number> hoge1 = new Hoge<Number>();
        Hoge<? super Integer> hoge2 = hoge1;

        // Integer型の値をセットすることができる。
        // つまり、値をセットする場合は反変のように振る舞う。
        hoge2.setObject(new Integer(10));

        // Number型の値を取得することはできない（コンパイルエラー）。
        // Number value = hoge2.getObject();
    }
}