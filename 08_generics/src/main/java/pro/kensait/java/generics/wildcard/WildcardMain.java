package pro.kensait.java.generics.wildcard;

// ワイルドカード
public class WildcardMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Hoge<Integer>型からInteger型を取得したり、セットしたりすることができる。
        Hoge<Integer> hoge1 = new Hoge<Integer>();
        Integer value = hoge1.getObject();
        hoge1.setObject(10);

        // Hoge<?>型は、「任意の型でパラメータ化されたHoge型」のスーパータイプに
        // なるので、以下のように代入が可能。
        Hoge<?> hoge2 = hoge1;

        // Hoge<?>型からは、Object型しか取得できない。
        Object obj = hoge2.getObject();

        // Hoge<?>型には、いかなる値もセットできない（コンパイルエラー）。
        // hoge2.setObject(new Object());

        // Hoge<?>からHoge<T>への代入はできない（コンパイルエラー）。
        // 従って以下のコードは、コンパイルエラーになる。
        // Hoge<Integer> hoge3 = hoge2;
        // この処理は、これだけ見ると問題ないように思える。
        // しかしこれを可能にしてしまうと、以下のようなコードもOKということに
        // なってしまうため、型の安全性が保証されない。
        // Hoge<String> hoge4 = new Hoge<String>();
        // Hoge<?> hoge5 = hoge4;
        // Hoge<Integer> hoge3 = hoge5;
    }
}